-- ============================================================
-- SEED: Roles
-- Table: roles (lowercase - PostgreSQL với globally_quoted_identifiers)
-- ============================================================

INSERT INTO roles (name, description, created_at, created_by, updated_at, updated_by)
VALUES
('ADMIN',  'Quản trị viên hệ thống, có toàn quyền',   NOW(), 'system', NOW(), 'system'),
('SELLER', 'Người bán hàng, quản lý sản phẩm & đơn',  NOW(), 'system', NOW(), 'system'),
('BUYER',  'Người mua hàng, duyệt & đặt sản phẩm',    NOW(), 'system', NOW(), 'system')

ON CONFLICT (name) DO UPDATE SET
    description = EXCLUDED.description,
    updated_at  = NOW(),
    updated_by  = 'system';


-- ============================================================
-- SEED: Role ↔ Permission mapping
-- Table: role_permission
-- ============================================================

-- ADMIN: tất cả quyền
INSERT INTO role_permission (role_id, permission_id)
SELECT 'ADMIN', name FROM permissions
ON CONFLICT (role_id, permission_id) DO NOTHING;

-- SELLER
INSERT INTO role_permission (role_id, permission_id)
VALUES
('SELLER', 'PRODUCT_READ'),
('SELLER', 'PRODUCT_CREATE'),
('SELLER', 'PRODUCT_UPDATE'),
('SELLER', 'PRODUCT_DELETE'),
('SELLER', 'ORDER_READ'),
('SELLER', 'ORDER_UPDATE'),
('SELLER', 'CATEGORY_READ')
ON CONFLICT (role_id, permission_id) DO NOTHING;

-- BUYER
INSERT INTO role_permission (role_id, permission_id)
VALUES
('BUYER', 'PRODUCT_READ'),
('BUYER', 'ORDER_CREATE'),
('BUYER', 'ORDER_READ'),
('BUYER', 'ORDER_CANCEL'),
('BUYER', 'CATEGORY_READ'),
('BUYER', 'USER_READ'),
('BUYER', 'USER_UPDATE')
ON CONFLICT (role_id, permission_id) DO NOTHING;
