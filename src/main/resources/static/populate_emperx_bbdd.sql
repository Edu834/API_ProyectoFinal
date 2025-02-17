use emperx_bbdd;

-- Insertar datos en la tabla estados (ejemplos de estados de los artículos)
INSERT INTO estados (nombre) VALUES
('Disponible'),
('Alquilado'),
('En mantenimiento'),
('Retirado');

-- Insertar datos en la tabla categorias (ejemplos de categorías de ropa)
INSERT INTO categorias (nombre, descripcion) VALUES
('Ropa Formal', 'Prendas de vestir formales para ocasiones especiales.'),
('Ropa Casual', 'Ropa cómoda y casual para uso diario.'),
('Ropa Deportiva', 'Prendas deportivas para actividades físicas y deportivas.');

-- Insertar datos en la tabla subcategorias (ejemplos de subcategorías dentro de ropa)
INSERT INTO subcategorias (id_categoria, nombre, descripcion) VALUES
(1, 'Trajes', 'Trajes formales para hombres y mujeres.'),
(1, 'Vestidos', 'Vestidos formales para mujeres.'),
(2, 'Camisetas', 'Camisetas de estilo casual para hombres y mujeres.'),
(2, 'Jeans', 'Jeans y pantalones casuales para todos los géneros.'),
(3, 'Ropa de entrenamiento', 'Prendas para actividades deportivas como gimnasia y running.');

-- Insertar datos en la tabla productos (ejemplos de productos de ropa)
INSERT INTO productos (id_producto, id_subcategoria, nombre, descripcion, marca) VALUES
('P001', 1, 'Traje de Gala Hombre', 'Traje de gala elegante para eventos formales.', 'Elegance Brand'),
('P002', 2, 'Vestido de Noche', 'Vestido de noche para ocasiones elegantes.', 'Luxe Couture'),
('P003', 3, 'Camiseta Básica', 'Camiseta casual de algodón para el día a día.', 'CottonWear'),
('P004', 4, 'Jeans Ajustados', 'Jeans de corte ajustado para mujeres.', 'DenimStyle'),
('P005', 5, 'Conjunto Deportivo', 'Conjunto deportivo cómodo para entrenar.', 'SportFit');

-- Insertar datos en la tabla usuarios (usuarios de la web)
INSERT INTO usuarios (id_usuario, username, password, email, direccion, sexo, telefono) VALUES
('U001', 'johndoe', 'password123', 'johndoe@example.com', 'Calle Ficticia 101, Ciudad', 'M', '694567145'),
('U002', 'janedoe', 'password456', 'janedoe@example.com', 'Avenida Real 202, Ciudad', 'F', '694567145'),
('U003', 'carolsmith', 'password789', 'carolsmith@example.com', 'Calle Luna 303, Ciudad', 'F', '694567145');

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
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, precio, descripcion) VALUES
('A001', 'P001', 'Traje de Gala Hombre', 'M', 'Negro', 10, 120.00, 'Traje elegante para eventos formales'),
('A002', 'P002', 'Vestido de Noche', 'L', 'Rojo', 5, 90.00, 'Vestido de noche para ocasiones especiales'),
('A003', 'P003', 'Camiseta Básica', 'M', 'Blanco', 50, 15.00, 'Camiseta cómoda para el día a día'),
('A004', 'P004', 'Jeans Ajustados', 'M', 'Azul', 30, 40.00, 'Jeans de corte ajustado para mujeres'),
('A005', 'P005', 'Conjunto Deportivo', 'L', 'Negro', 20, 50.00, 'Conjunto deportivo cómodo y versátil');

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
