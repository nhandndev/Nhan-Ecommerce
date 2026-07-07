-- ============================================================
-- SEED: Permissions
-- Table: Permissions
-- ============================================================

INSERT INTO Permissions (name, description, created_at, created_by, updated_at, updated_by)
VALUES
-- USER permissions
('USER_READ',       'Xem thông tin người dùng',             NOW(), 'system', NOW(), 'system'),
('USER_UPDATE',     'Cập nhật thông tin người dùng',        NOW(), 'system', NOW(), 'system'),
('USER_DELETE',     'Xóa người dùng',                       NOW(), 'system', NOW(), 'system'),
('USER_CREATE',     'Tạo người dùng mới',                   NOW(), 'system', NOW(), 'system'),

-- PRODUCT permissions
('PRODUCT_READ',    'Xem sản phẩm',                         NOW(), 'system', NOW(), 'system'),
('PRODUCT_CREATE',  'Tạo sản phẩm mới',                     NOW(), 'system', NOW(), 'system'),
('PRODUCT_UPDATE',  'Cập nhật sản phẩm',                    NOW(), 'system', NOW(), 'system'),
('PRODUCT_DELETE',  'Xóa sản phẩm',                         NOW(), 'system', NOW(), 'system'),

-- ORDER permissions
('ORDER_READ',      'Xem đơn hàng',                         NOW(), 'system', NOW(), 'system'),
('ORDER_CREATE',    'Tạo đơn hàng',                         NOW(), 'system', NOW(), 'system'),
('ORDER_UPDATE',    'Cập nhật đơn hàng',                    NOW(), 'system', NOW(), 'system'),
('ORDER_CANCEL',    'Hủy đơn hàng',                         NOW(), 'system', NOW(), 'system'),

-- CATEGORY permissions
('CATEGORY_READ',   'Xem danh mục',                         NOW(), 'system', NOW(), 'system'),
('CATEGORY_CREATE', 'Tạo danh mục',                         NOW(), 'system', NOW(), 'system'),
('CATEGORY_UPDATE', 'Cập nhật danh mục',                    NOW(), 'system', NOW(), 'system'),
('CATEGORY_DELETE', 'Xóa danh mục',                         NOW(), 'system', NOW(), 'system'),

-- ADMIN permissions
('ADMIN_DASHBOARD', 'Truy cập trang quản trị',              NOW(), 'system', NOW(), 'system'),
('ROLE_MANAGE',     'Quản lý vai trò người dùng',           NOW(), 'system', NOW(), 'system')

ON DUPLICATE KEY UPDATE
    description = VALUES(description),
    updated_at  = NOW(),
    updated_by  = 'system';
