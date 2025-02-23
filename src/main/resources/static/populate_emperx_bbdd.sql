use emperx_bbdd;

-- Insertar datos en la tabla estados (ejemplos de estados de los artículos)
INSERT INTO estados (nombre) VALUES
('Disponible'),
('Alquilado'),
('En mantenimiento'),
('Retirado');

-- Insertar datos en la tabla categorias (ejemplos de categorías de ropa)
INSERT INTO categorias (nombre, descripcion) VALUES
('Ready-to-wear', 'Prendas de vestir formales para ocasiones especiales.'),
('Bags', 'Ropa cómoda y casual para uso diario.'),
('Shoes', 'Prendas deportivas para actividades físicas y deportivas.'),
('Accessories', 'Prendas deportivas para actividades físicas y deportivas.');

-- Insertar datos en la tabla subcategorias (ejemplos de subcategorías dentro de ropa)
INSERT INTO subcategorias (id_categoria, nombre, descripcion) VALUES
(1, 'Trajes', 'Trajes formales para hombres y mujeres.'),
(1, 'Vestidos', 'Vestidos formales para mujeres.'),
(2, 'Camisetas', 'Camisetas de estilo casual para hombres y mujeres.'),
(2, 'Jeans', 'Jeans y pantalones casuales para todos los géneros.'),
(3, 'Ropa de entrenamiento', 'Prendas para actividades deportivas como gimnasia y running.');

-- Insertar datos en la tabla productos (ejemplos de productos de ropa)
-- Insertar productos
INSERT INTO productos (id_producto, id_subcategoria, nombre, descripcion, marca, sexo) VALUES
('P001', 1, 'Traje de Gala Hombre', 'Traje de gala elegante para eventos formales.', 'Elegance Brand', 'H'),
('P002', 2, 'Vestido de Noche', 'Vestido de noche para ocasiones elegantes.', 'Luxe Couture', 'M'),
('P003', 3, 'Camiseta Básica', 'Camiseta casual de algodón para el día a día.', 'CottonWear', 'UNISEX'),
('P004', 4, 'Jeans Ajustados', 'Jeans de corte ajustado para mujeres.', 'DenimStyle', 'M'),
('P005', 5, 'Conjunto Deportivo', 'Conjunto deportivo cómodo para entrenar.', 'SportFit', 'H'),
('P006', 1, 'Traje Formal Mujer', 'Traje formal elegante para mujeres', 'ElegantWear', 'M'),
('P007', 2, 'Blusa Casual', 'Blusa liviana y cómoda para el día a día', 'CasualLife', 'UNISEX'),
('P008', 3, 'Pantalón Deportivo', 'Pantalón cómodo para entrenar', 'ActiveWear', 'UNISEX'),
('P009', 4, 'Chaqueta de Cuero', 'Chaqueta de cuero para ocasiones casuales', 'LeatherStyle', 'UNISEX'),
('P010', 5, 'Sudadera Deportiva', 'Sudadera para actividades deportivas o de descanso', 'SportLife', 'UNISEX');


-- Insertar datos en la tabla usuarios (usuarios de la web)
INSERT INTO usuarios (id_usuario, username, firstname, lastname, password, email, direccion, sexo, telefono) VALUES
('U001', 'johndoe', 'John', 'Doe', 'password123', 'johndoe@example.com', 'Calle Ficticia 101, Ciudad', 'M', '694567145'),
('U002', 'janedoe', 'Jane', 'Doe','password456', 'janedoe@example.com', 'Avenida Real 202, Ciudad', 'H', '694567145'),
('U003', 'carolsmith', 'Carol', 'Smith','password789', 'carolsmith@example.com', 'Calle Luna 303, Ciudad', 'H', '694567145');

-- Insertar datos en la tabla perfiles (tipos de usuarios)
INSERT INTO perfiles (nombre) VALUES
('Cliente'),
('Administrador'),
('Vendedor');

-- Insertar datos en la tabla usuario_con_perfiles (asociaciones de usuarios con perfiles)
INSERT INTO usuario_con_perfiles (id_usuario, id_perfil) VALUES
('U001', 1),
('U002', 1),
('U003', 1),
('U002', 2); -- Administrador

-- Insertar datos en la tabla pedidos (pedidos realizados por los usuarios)
INSERT INTO pedidos (id_pedido, id_usuario, descripcion, fecha, estado, fecha_entrega) VALUES
('P001', 'U001', 'Alquiler de traje para boda', '2025-02-14', 'Completado', '2025-02-20'),
('P002', 'U003', 'Alquiler de vestido de noche', '2025-02-14', 'Entregado', '2025-02-18'),
('P003', 'U002', 'Alquiler de conjunto deportivo', '2025-02-14', 'Carrito', NULL);

-- Insertar datos en la tabla articulo (artículos disponibles para alquilar)
-- Insertar artículos
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, precio, descripcion) VALUES
('A001', 'P001', 'Traje de Gala Hombre', 'M', 'Negro', 10, 120.00, 'Traje elegante para eventos formales'),
('A002', 'P002', 'Vestido de Noche', 'L', 'Rojo', 5, 90.00, 'Vestido de noche para ocasiones especiales'),
('A003', 'P003', 'Camiseta Básica', 'M', 'Blanco', 50, 15.00, 'Camiseta cómoda para el día a día'),
('A004', 'P004', 'Jeans Ajustados', 'M', 'Azul', 30, 40.00, 'Jeans de corte ajustado para mujeres'),
('A005', 'P005', 'Conjunto Deportivo', 'L', 'Negro', 20, 50.00, 'Conjunto deportivo cómodo y versátil'),
('A006', 'P006', 'Traje Formal Mujer', 'M', 'Azul', 15, 130.00, 'Traje elegante para mujeres en eventos formales'),
('A007', 'P007', 'Blusa Casual', 'L', 'Blanco', 40, 25.00, 'Blusa casual de algodón para el día a día'),
('A008', 'P008', 'Pantalón Deportivo', 'L', 'Negro', 25, 45.00, 'Pantalón deportivo cómodo para entrenar'),
('A009', 'P009', 'Chaqueta de Cuero', 'M', 'Negro', 15, 100.00, 'Chaqueta de cuero para ocasiones casuales'),
('A010', 'P010', 'Sudadera Deportiva', 'M', 'Gris', 35, 40.00, 'Sudadera para actividades deportivas o de descanso'),
('A011', 'P001', 'Traje de Gala Hombre', 'L', 'Negro', 5, 125.00, 'Traje elegante para eventos formales'),
('A012', 'P002', 'Vestido de Noche', 'M', 'Negro', 10, 95.00, 'Vestido de noche para ocasiones especiales'),
('A013', 'P003', 'Camiseta Básica', 'L', 'Azul', 55, 16.00, 'Camiseta cómoda para el día a día'),
('A014', 'P004', 'Jeans Ajustados', 'L', 'Negro', 28, 42.00, 'Jeans de corte ajustado para mujeres'),
('A015', 'P005', 'Conjunto Deportivo', 'M', 'Rojo', 25, 55.00, 'Conjunto deportivo cómodo y versátil'),
('A016', 'P006', 'Traje Formal Mujer', 'L', 'Rojo', 12, 135.00, 'Traje elegante para mujeres en eventos formales'),
('A017', 'P007', 'Blusa Casual', 'M', 'Verde', 38, 28.00, 'Blusa casual de algodón para el día a día'),
('A018', 'P008', 'Pantalón Deportivo', 'M', 'Azul', 18, 47.00, 'Pantalón deportivo cómodo para entrenar'),
('A019', 'P009', 'Chaqueta de Cuero', 'L', 'Negro', 20, 105.00, 'Chaqueta de cuero para ocasiones casuales'),
('A020', 'P010', 'Sudadera Deportiva', 'L', 'Azul', 30, 42.00, 'Sudadera para actividades deportivas o de descanso'),
('A021', 'P001', 'Traje de Gala Hombre', 'M', 'Azul', 12, 118.00, 'Traje elegante para eventos formales'),
('A022', 'P002', 'Vestido de Noche', 'S', 'Blanco', 8, 92.00, 'Vestido de noche para ocasiones especiales'),
('A023', 'P003', 'Camiseta Básica', 'S', 'Negro', 60, 14.50, 'Camiseta cómoda para el día a día'),
('A024', 'P004', 'Jeans Ajustados', 'M', 'Verde', 33, 44.00, 'Jeans de corte ajustado para mujeres'),
('A025', 'P005', 'Conjunto Deportivo', 'XL', 'Gris', 22, 52.00, 'Conjunto deportivo cómodo y versátil'),
('A026', 'P006', 'Traje Formal Mujer', 'M', 'Negro', 17, 132.00, 'Traje elegante para mujeres en eventos formales'),
('A027', 'P007', 'Blusa Casual', 'S', 'Rojo', 45, 26.00, 'Blusa casual de algodón para el día a día'),
('A028', 'P008', 'Pantalón Deportivo', 'L', 'Rojo', 19, 48.00, 'Pantalón deportivo cómodo para entrenar'),
('A029', 'P009', 'Chaqueta de Cuero', 'M', 'Café', 10, 98.00, 'Chaqueta de cuero para ocasiones casuales'),
('A030', 'P010', 'Sudadera Deportiva', 'M', 'Negro', 35, 40.00, 'Sudadera para actividades deportivas o de descanso'),
('A031', 'P001', 'Traje de Gala Hombre', 'L', 'Negro', 9, 120.00, 'Traje elegante para eventos formales'),
('A032', 'P002', 'Vestido de Noche', 'L', 'Rojo', 7, 93.00, 'Vestido de noche para ocasiones especiales'),
('A033', 'P003', 'Camiseta Básica', 'M', 'Amarillo', 48, 16.00, 'Camiseta cómoda para el día a día'),
('A034', 'P004', 'Jeans Ajustados', 'S', 'Azul', 36, 39.00, 'Jeans de corte ajustado para mujeres'),
('A035', 'P005', 'Conjunto Deportivo', 'M', 'Azul', 30, 53.00, 'Conjunto deportivo cómodo y versátil'),
('A036', 'P006', 'Traje Formal Mujer', 'L', 'Azul', 20, 138.00, 'Traje elegante para mujeres en eventos formales'),
('A037', 'P007', 'Blusa Casual', 'L', 'Blanco', 33, 27.00, 'Blusa casual de algodón para el día a día'),
('A038', 'P008', 'Pantalón Deportivo', 'S', 'Negro', 21, 46.00, 'Pantalón deportivo cómodo para entrenar'),
('A039', 'P009', 'Chaqueta de Cuero', 'S', 'Negro', 17, 102.00, 'Chaqueta de cuero para ocasiones casuales'),
('A040', 'P010', 'Sudadera Deportiva', 'L', 'Rojo', 28, 41.00, 'Sudadera para actividades deportivas o de descanso');


-- Insertar datos en la tabla articulos_con_estados (relación de artículos con sus estados)
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A001', 1),  -- Disponible
('A002', 1),  -- Disponible
('A003', 1),  -- Disponible
('A004', 1),  -- Disponible
('A005', 1);  -- Disponible

-- Insertar datos en la tabla articulos_en_pedidos (relación de artículos con pedidos)
INSERT INTO articulos_en_pedidos (id_articulo, id_pedido, cantidad, cantidad_devuelta, estado, fecha_devuelta) VALUES
('A002', 'P002', 1, 0, 'Alquilado', NULL),  -- Alquilado
('A003', 'P003', 2, 0, 'Disponible', NULL),  -- En el carrito
('A001', 'P002', 1, 0, 'Alquilado', NULL),  -- Alquilado
('A005', 'P003', 2, 0, 'Disponible', NULL),  -- En el carrito
('A002', 'P003', 1, 0, 'Disponible', NULL),  -- En el carrito
('A004', 'P002', 3, 0, 'Alquilado', NULL);  -- Alquilado

-- Insertar datos en la tabla articulos_en_pedidos con artículos devueltos
INSERT INTO articulos_en_pedidos (id_articulo, id_pedido, cantidad, cantidad_devuelta, estado, fecha_devuelta) VALUES
('A001', 'P001', 1, 1, 'Devuelto', '2025-02-22'),  -- Alquilado y devuelto
('A002', 'P001', 1, 1, 'Devuelto', '2025-03-02'),  -- Alquilado y devuelto
('A005', 'P001', 1, 1, 'Devuelto', '2025-03-02');  -- Alquilado y devuelto
