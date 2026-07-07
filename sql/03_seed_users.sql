-- ============================================================
-- SEED: Users
-- Table: Users
-- NOTE: Passwords below are BCrypt-hashed của "admin123"
--       Hash: $2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG
-- ============================================================

INSERT INTO Users (email, full_name, phone_number, password, status, created_at, created_by, updated_at, updated_by)
VALUES
-- ADMIN
('admin@nhanshop.com',
 'Nguyễn Quản Trị',
 '0900000001',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'ACTIVE',
 NOW(), 'system', NOW(), 'system'),

-- SELLERS
('seller1@nhanshop.com',
 'Trần Văn Bán',
 '0900000002',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'ACTIVE',
 NOW(), 'system', NOW(), 'system'),

('seller2@nhanshop.com',
 'Lê Thị Shop',
 '0900000003',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'ACTIVE',
 NOW(), 'system', NOW(), 'system'),

-- BUYERS
('buyer1@nhanshop.com',
 'Phạm Văn Mua',
 '0900000004',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'ACTIVE',
 NOW(), 'system', NOW(), 'system'),

('buyer2@nhanshop.com',
 'Hoàng Thị Khách',
 '0900000005',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'ACTIVE',
 NOW(), 'system', NOW(), 'system'),

('buyer3@nhanshop.com',
 'Ngô Minh Tuấn',
 '0900000006',
 '$2a$10$CimHFFOxwCLdiWDSGo.3UOe4uoCsCMeD/tseGP5oyKqct0hP90GfG',
 'INACTIVE',
 NOW(), 'system', NOW(), 'system')

ON DUPLICATE KEY UPDATE
    full_name    = VALUES(full_name),
    updated_at   = NOW(),
    updated_by   = 'system';


-- ============================================================
-- SEED: User ↔ Role mapping
-- Table: user_roles
-- ============================================================

-- Gán role ADMIN cho admin@nhanshop.com
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, 'ADMIN'
FROM Users u
WHERE u.email = 'admin@nhanshop.com'
ON DUPLICATE KEY UPDATE user_id = user_id;

-- Gán role SELLER cho seller1 & seller2
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, 'SELLER'
FROM Users u
WHERE u.email IN ('seller1@nhanshop.com', 'seller2@nhanshop.com')
ON DUPLICATE KEY UPDATE user_id = user_id;

-- Gán role BUYER cho buyer1, buyer2, buyer3
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, 'BUYER'
FROM Users u
WHERE u.email IN ('buyer1@nhanshop.com', 'buyer2@nhanshop.com', 'buyer3@nhanshop.com')
ON DUPLICATE KEY UPDATE user_id = user_id;
