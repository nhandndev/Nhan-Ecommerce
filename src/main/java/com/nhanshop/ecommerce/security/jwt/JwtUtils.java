package com.nhanshop.ecommerce.security.jwt;

import com.nhanshop.ecommerce.common.exception.AppException;
import com.nhanshop.ecommerce.common.exception.ErrorCode;
import com.nhanshop.ecommerce.user.entity.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtUtils {
    @Value("$.{jwt.signKey}")
    private String signKey;
    public String generateToken(User user) {
        JWSHeader jwsHeader = new JWSHeader.Builder((JWSAlgorithm.HS256)).type(JOSEObjectType.JWT).build();
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .jwtID(UUID.randomUUID().toString())
                .subject(user.getFullName())
                .issuer("DoanNgocNhan")
                .issueTime(Date.from(Instant.now()))
                .expirationTime(Date.from(Instant.now().plusSeconds(3600))) //3600 equal 1 hours
                .claim("scope", buildScope(user))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader,payload);
        try{
            jwsObject.sign(new MACSigner(signKey));
        }catch (JOSEException e){
            throw new AppException(ErrorCode.INVALID_TOKEN);
        }
        return jwsObject.serialize();
    }
    public String buildScope(User user){
        StringJoiner stringJoiner = new StringJoiner(" ");
        if(user.getRoles() == null && user.getRoles().isEmpty()){
            return "";
        }
        var roles = user.getRoles();
        for( var role : roles){
            String roleName = role.getName();
            String formatRole = roleName.startsWith("ROLE_")? roleName :"ROLE_"+roleName;
            stringJoiner.add(formatRole);
            for(var permission : role.getPermissions()){
                stringJoiner.add(permission.getName());
            }
        }
        return stringJoiner.toString();
    }
    public SignedJWT verifyToken(String token) throws  JOSEException , ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWSVerifier jwsVerifier = new MACVerifier(signKey);
        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        Boolean verified = signedJWT.verify(jwsVerifier);
        if(!verified || expirationTime.after(Date.from(Instant.now()))){
            throw new AppException(ErrorCode.INVALID_TOKEN);
        }
        return signedJWT;
    }

}
