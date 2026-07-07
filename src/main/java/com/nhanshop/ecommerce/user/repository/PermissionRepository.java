package com.nhanshop.ecommerce.user.repository;

import com.nhanshop.ecommerce.user.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,String> {

}
