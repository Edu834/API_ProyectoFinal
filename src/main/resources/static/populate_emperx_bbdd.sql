use emperx_bbdd;

INSERT INTO galerias (
    foto_frontal,
    foto_trasera,
    foto_modelo_frontal,
    foto_modelo_trasera,
    foto_modelo_costado,
    foto_modelo_cerca
)



VALUES (
    '/images/foto_frontal_classic_suit.jpg',
    '/images/foto_trasera_classic_suit.jpg',
    '/images/foto_modelo_frontal_classic_suit.jpg',
    '/images/foto_modelo_trasera_classic_suit.jpg',
    '/images/foto_modelo_costado_classic_suit.jpg',
    '/images/foto_modelo_cerca_classic_suit.jpg'
),(
    '/images/foto_frontal_slim_suit.jpg',
    '/images/foto_trasera_slim_suit.jpg',
    '/images/foto_modelo_frontal_slim_suit.jpg',
    '/images/foto_modelo_trasera_slim_suit.jpg',
    '/images/foto_modelo_costado_slim_suit.jpg',
    '/images/foto_modelo_cerca_slim_suit.jpg'
),(
    '/images/foto_frontal_formal_blazer.jpg',
    '/images/foto_trasera_formal_blazer.jpg',
    '/images/foto_modelo_frontal_formal_blazer.jpg',
    '/images/foto_modelo_trasera_formal_blazer.jpg',
    '/images/foto_modelo_costado_formal_blazer.jpg',
    '/images/foto_modelo_cerca_formal_blazer.jpg'
),(
    '/images/foto_frontal_doble-breasted_suit.jpg',
    '/images/foto_trasera_doble-breasted_suit.jpg',
    '/images/foto_modelo_frontal_doble-breasted_suit.jpg',
    '/images/foto_modelo_trasera_doble-breasted_suit.jpg',
    '/images/foto_modelo_costado_doble-breasted_suit.jpg',
    '/images/foto_modelo_cerca_doble-breasted_suit.jpg'
),(
    '/images/foto_frontal_winter_coat.jpg',
    '/images/foto_trasera_winter_coat.jpg',
    '/images/foto_modelo_frontal_winter_coat.jpg',
    '/images/foto_modelo_trasera_winter_coat.jpg',
    '/images/foto_modelo_costado_winter_coat.jpg',
    '/images/foto_modelo_cerca_winter_coat.jpg'
),(
    '/images/foto_frontal_trench_coat.jpg',
    '/images/foto_trasera_trench_coat.jpg',
    '/images/foto_modelo_frontal_trench_coat.jpg',
    '/images/foto_modelo_trasera_trench_coat.jpg',
    '/images/foto_modelo_costado_trench_coat.jpg',
    '/images/foto_modelo_cerca_trench_coat.jpg'
),(
    '/images/foto_frontal_leather_jacket.jpg',
    '/images/foto_trasera_leather_jacket.jpg',
    '/images/foto_modelo_frontal_leather_jacket.jpg',
    '/images/foto_modelo_trasera_leather_jacket.jpg',
    '/images/foto_modelo_costado_leather_jacket.jpg',
    '/images/foto_modelo_cerca_leather_jacket.jpg'
),(
    '/images/foto_frontal_blazer.jpg',
    '/images/foto_trasera_blazer.jpg',
    '/images/foto_modelo_frontal_blazer.jpg',
    '/images/foto_modelo_trasera_blazer.jpg',
    '/images/foto_modelo_costado_blazer.jpg',
    '/images/foto_modelo_cerca_blazer.jpg'
),(
    '/images/foto_frontal_evening_dress.jpg',
    '/images/foto_trasera_evening_dress.jpg',
    '/images/foto_modelo_frontal_evening_dress.jpg',
    '/images/foto_modelo_trasera_evening_dress.jpg',
    '/images/foto_modelo_costado_evening_dress.jpg',
    '/images/foto_modelo_cerca_evening_dress.jpg'
),(
    '/images/foto_frontal_cocktail_dress.jpg',
    '/images/foto_trasera_cocktail_dress.jpg',
    '/images/foto_modelo_frontal_cocktail_dress.jpg',
    '/images/foto_modelo_trasera_cocktail_dress.jpg',
    '/images/foto_modelo_costado_cocktail_dress.jpg',
    '/images/foto_modelo_cerca_cocktail_dress.jpg'
);


-- Insertamos los estados de los artículos
INSERT INTO estados (nombre) VALUES
('Alquilado'),
('Retirado'),
('Disponible'),
('Nuevo'),
('Algo Usado'),
('Usado'),
('Mal Estado');


-- Insertamos las categorías
INSERT INTO categorias (nombre, descripcion) VALUES
('Ready-to-wear', 'Ropa lista para usar, cómoda y versátil.'),
('Bags', 'Bolsos de diferentes tamaños y estilos para todo tipo de ocasiones.'),
('Shoes', 'Zapatos y calzado de todas las formas y estilos.'),
('Accessories', 'Accesorios que complementan tu look, desde joyas hasta sombreros.');

-- Insertamos las subcategorías, asignadas a las categorías correspondientes
INSERT INTO subcategorias (id_categoria, nombre, descripcion) VALUES
(1, 'Suits', 'Trajes formales para diferentes ocasiones'),
(1, 'Coats & Jackets', 'Abrigos y chaquetas para diversas estaciones del año'),
(1, 'Dresses', 'Vestidos para cualquier ocasión'),
(1, 'Skirts', 'Faldas de todos los estilos'),
(1, 'T-Shirts', 'Camisetas de diferentes colores y estilos'),
(1, 'Tops & Bodysuits', 'Tops y bodies de diferentes diseños'),
(1, 'Jeans & Trousers', 'Jeans y pantalones de todo tipo'),
(1, 'Knitwear', 'Prendas de punto para cualquier temporada'),
(1, 'Sweatshirts', 'Sudaderas y prendas deportivas'),
(2, 'Totes', 'Bolsos grandes y espaciosos'),
(2, 'Clutches', 'Bolsos pequeños y elegantes'),
(3, 'Boots', 'Botas para todo tipo de clima y ocasión'),
(3, 'Sneakers', 'Zapatillas deportivas para el día a día'),
(4, 'Watches', 'Relojes de diferentes estilos'),
(4, 'Hats', 'Sombreros de todo tipo');





INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P001', 1, 1, 'Classic Suit', 'Traje clásico de corte recto, adecuado para ocasiones formales', 'BrandX', 'H', 150.00),
('P002', 1, 2, 'Slim Fit Suit', 'Traje ajustado para un look moderno', 'BrandY', 'H', 180.00),
('P003', 1, 3, 'Formal Blazer', 'Blazer formal de corte recto, ideal para eventos', 'BrandZ', 'H', 120.00),
('P004', 1, 4, 'Double-breasted Suit', 'Traje de doble botonadura elegante y sofisticado', 'BrandA', 'M', 200.00),
('P005', 2, 5, 'Winter Coat', 'Abrigo de lana para invierno', 'BrandB', 'H', 160.00),
('P006', 2, 6, 'Trench Coat', 'Abrigo estilo trench, ligero para la primavera', 'BrandC', 'M', 130.00),
('P007', 2, 7, 'Leather Jacket', 'Chaqueta de cuero, ideal para la temporada de otoño', 'BrandD', 'H', 180.00),
('P008', 2, 8, 'Blazer', 'Blazer formal con corte ajustado', 'BrandE', 'H', 140.00),
('P009', 3, 9, 'Evening Dress', 'Vestido largo y elegante para eventos formales', 'BrandF', 'M', 220.00),
('P010', 3, 10, 'Cocktail Dress', 'Vestido corto y elegante para cócteles', 'BrandG', 'M', 160.00),
('P011', 3, null, 'Day Dress', 'Vestido casual para el día a día', 'BrandH', 'M', 90.00),
('P012', 3, null, 'Maxi Dress', 'Vestido largo, ideal para la playa o eventos formales', 'BrandI', 'M', 180.00),
('P013', 4, null, 'A-Line Skirt', 'Falda de corte A, ideal para todos los días', 'BrandJ', 'M', 50.00),
('P014', 4, null, 'Pencil Skirt', 'Falda de tubo ajustada para ocasiones formales', 'BrandK', 'M', 60.00),
('P015', 4, null, 'Pleated Skirt', 'Falda plisada de largo medio', 'BrandL', 'M', 55.00),
('P016', 4, null, 'Mini Skirt', 'Falda corta para un look más casual', 'BrandM', 'M', 45.00),
('P017', 5, null, 'Basic T-Shirt', 'Camiseta básica de algodón, cómoda para el día a día', 'BrandN', 'H', 20.00),
('P018', 5, null, 'Graphic T-Shirt', 'Camiseta con diseño gráfico moderno', 'BrandO', 'H', 25.00),
('P019', 5, null, 'V-neck T-Shirt', 'Camiseta de cuello en V, ideal para días calurosos', 'BrandP', 'H', 22.00),
('P020', 5, null, 'Long Sleeve T-Shirt', 'Camiseta de manga larga, perfecta para el otoño', 'BrandQ', 'H', 28.00),
('P021', 6, null, 'Body Top', 'Top de cuerpo ajustado, ideal para combinar con faldas', 'BrandR', 'M', 35.00),
('P022', 6, null, 'Crop Top', 'Top corto, muy de moda', 'BrandS', 'M', 30.00),
('P023', 6, null, 'Blouse', 'Blusa elegante para ocasiones formales', 'BrandT', 'M', 50.00),
('P024', 6, null, 'Tank Top', 'Top sin mangas, ideal para el verano', 'BrandU', 'M', 18.00),
('P025', 7, null, 'Slim Fit Jeans', 'Jeans de corte ajustado, ideal para el día a día', 'BrandV', 'H', 55.00),
('P026', 7, null, 'Bootcut Jeans', 'Jeans de corte acampanado', 'BrandW', 'M', 60.00),
('P027', 7, null, 'Chinos', 'Pantalones chinos, versátiles y cómodos', 'BrandX', 'H', 50.00),
('P028', 7, null, 'Dress Trousers', 'Pantalones de vestir, adecuados para eventos formales', 'BrandY', 'M', 70.00),
('P029', 8, null, 'Knit Sweater', 'Suéter de punto suave, ideal para el invierno', 'BrandZ', 'M', 80.00),
('P030', 8, null, 'Cashmere Sweater', 'Suéter de cachemira de alta calidad', 'BrandA', 'M', 120.00),
('P031', 8, null, 'Cardigan', 'Cárdigan largo, cómodo para el otoño', 'BrandB', 'H', 60.00),
('P032', 8, null, 'Turtleneck Sweater', 'Suéter de cuello alto, ideal para el invierno', 'BrandC', 'H', 75.00),
('P033', 9, null, 'Hoodie Sweatshirt', 'Sudadera con capucha, cómoda y deportiva', 'BrandD', 'H', 45.00),
('P034', 9, null, 'Crewneck Sweatshirt', 'Sudadera de cuello redondo', 'BrandE', 'H', 40.00),
('P035', 9, null, 'Zip-up Sweatshirt', 'Sudadera con cremallera, fácil de poner y quitar', 'BrandF', 'M', 50.00),
('P036', 9, null, 'Fleece Sweatshirt', 'Sudadera de forro polar, muy abrigada', 'BrandG', 'H', 60.00);


-- Insertar productos para Totes
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P037', 10, null, 'Tote Bag Classic', 'Bolso grande y espacioso para todo el día', 'BrandT', 'M', 50.00),
('P038', 10, null, 'Tote Bag Modern', 'Bolso moderno y de gran capacidad', 'BrandU', 'M', 55.00);

-- Insertar productos para Clutches
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P039', 11, null, 'Leather Clutch', 'Clutch de cuero elegante', 'BrandV', 'M', 80.00),
('P040', 11, null, 'Silk Clutch', 'Clutch de seda, sofisticado y refinado', 'BrandW', 'M', 75.00);

-- Insertar productos para Boots
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P041', 12, null, 'Leather Boots', 'Botas de cuero elegantes', 'BrandX', 'M', 120.00),
('P042', 12, null, 'Suede Boots', 'Botas de ante suaves y cómodas', 'BrandY', 'H', 110.00);

-- Insertar productos para Sneakers
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P043', 13, null, 'Sporty Sneakers', 'Zapatillas deportivas para el día a día', 'BrandZ', 'H', 60.00),
('P044', 13, null, 'Casual Sneakers', 'Zapatillas casuales para el fin de semana', 'BrandA', 'M', 55.00);

-- Insertar productos para Watches
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P045', 14, null, 'Leather Strap Watch', 'Reloj de pulsera con correa de cuero', 'BrandB', 'H', 90.00),
('P046', 14, null, 'Metal Strap Watch', 'Reloj de pulsera con correa metálica', 'BrandC', 'H', 120.00);

-- Insertar productos para Hats
INSERT INTO productos (id_producto, id_subcategoria, id_galeria, nombre, descripcion, marca, sexo, precio) VALUES
('P047', 15, null, 'Fedora Hat', 'Sombrero de ala ancha estilo fedora', 'BrandD', 'M', 50.00),
('P048', 15, null, 'Beanie Hat', 'Sombrero de lana ajustado, ideal para invierno', 'BrandE', 'H', 25.00);

-- Artículos para los productos de la subcategoría 'Suits'

-- Artículos para el producto 'Classic Suit'

INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A001', 'P001', 'Classic Suit - Talla S', 'S', 'Negro', 10, '#000000', 'Traje clásico de corte recto, adecuado para ocasiones formales'),
('A002', 'P001', 'Classic Suit - Talla M', 'M', 'Gris', 15, '#808080', 'Traje clásico de corte recto, adecuado para ocasiones formales'),
('A003', 'P001', 'Classic Suit - Talla L', 'L', 'Azul', 8, '#0000FF', 'Traje clásico de corte recto, adecuado para ocasiones formales'),
('A004', 'P001', 'Classic Suit - Talla XL', 'XL', 'Negro', 6, '#000000', 'Traje clásico de corte recto, adecuado para ocasiones formales'),
('A005', 'P001', 'Classic Suit - Talla XXL', 'XXL', 'Gris', 4, '#808080', 'Traje clásico de corte recto, adecuado para ocasiones formales');



-- Artículos para el producto 'Slim Fit Suit'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A006', 'P002', 'Slim Fit Suit - Talla S', 'S', 'Negro', 12, '#000000', 'Traje ajustado para un look moderno'),
('A007', 'P002', 'Slim Fit Suit - Talla M', 'M', 'Gris', 14, '#808080', 'Traje ajustado para un look moderno'),
('A008', 'P002', 'Slim Fit Suit - Talla L', 'L', 'Azul', 10, '#0000FF', 'Traje ajustado para un look moderno'),
('A009', 'P002', 'Slim Fit Suit - Talla XL', 'XL', 'Negro', 7, '#000000', 'Traje ajustado para un look moderno'),
('A010', 'P002', 'Slim Fit Suit - Talla XXL', 'XXL', 'Gris', 5, '#808080', 'Traje ajustado para un look moderno');

-- Artículos para el producto 'Formal Blazer'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A011', 'P003', 'Formal Blazer - Talla S', 'S', 'Negro', 20, '#000000', 'Blazer formal de corte recto, ideal para eventos'),
('A012', 'P003', 'Formal Blazer - Talla M', 'M', 'Gris', 18, '#808080', 'Blazer formal de corte recto, ideal para eventos'),
('A013', 'P003', 'Formal Blazer - Talla L', 'L', 'Azul', 16, '#0000FF', 'Blazer formal de corte recto, ideal para eventos'),
('A014', 'P003', 'Formal Blazer - Talla XL', 'XL', 'Negro', 12, '#000000', 'Blazer formal de corte recto, ideal para eventos'),
('A015', 'P003', 'Formal Blazer - Talla XXL', 'XXL', 'Gris', 10, '#808080', 'Blazer formal de corte recto, ideal para eventos');

-- Artículos para el producto 'Double-breasted Suit'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A016', 'P004', 'Double-breasted Suit - Talla S', 'S', 'Negro', 8, '#000000', 'Traje de doble botonadura elegante y sofisticado'),
('A017', 'P004', 'Double-breasted Suit - Talla M', 'M', 'Gris', 6, '#808080', 'Traje de doble botonadura elegante y sofisticado'),
('A018', 'P004', 'Double-breasted Suit - Talla L', 'L', 'Azul', 5, '#0000FF', 'Traje de doble botonadura elegante y sofisticado'),
('A019', 'P004', 'Double-breasted Suit - Talla XL', 'XL', 'Negro', 4, '#000000', 'Traje de doble botonadura elegante y sofisticado'),
('A020', 'P004', 'Double-breasted Suit - Talla XXL', 'XXL', 'Gris', 3, '#808080', 'Traje de doble botonadura elegante y sofisticado');

-- Artículos para el producto 'Winter Coat'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A021', 'P005', 'Winter Coat - Talla S', 'S', 'Negro', 15, '#000000', 'Abrigo de lana para invierno'),
('A022', 'P005', 'Winter Coat - Talla M', 'M', 'Gris', 12, '#808080', 'Abrigo de lana para invierno'),
('A023', 'P005', 'Winter Coat - Talla L', 'L', 'Azul', 10, '#0000FF', 'Abrigo de lana para invierno'),
('A024', 'P005', 'Winter Coat - Talla XL', 'XL', 'Negro', 8, '#000000', 'Abrigo de lana para invierno'),
('A025', 'P005', 'Winter Coat - Talla XXL', 'XXL', 'Gris', 5, '#808080', 'Abrigo de lana para invierno');

-- Artículos para el producto 'Trench Coat'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A026', 'P006', 'Trench Coat - Talla S', 'S', 'Beige', 20, '#F5F5DC', 'Abrigo estilo trench, ligero para la primavera'),
('A027', 'P006', 'Trench Coat - Talla M', 'M', 'Negro', 18, '#000000', 'Abrigo estilo trench, ligero para la primavera'),
('A028', 'P006', 'Trench Coat - Talla L', 'L', 'Verde', 15, '#008000', 'Abrigo estilo trench, ligero para la primavera'),
('A029', 'P006', 'Trench Coat - Talla XL', 'XL', 'Beige', 12, '#F5F5DC', 'Abrigo estilo trench, ligero para la primavera'),
('A030', 'P006', 'Trench Coat - Talla XXL', 'XXL', 'Negro', 10, '#000000', 'Abrigo estilo trench, ligero para la primavera');

-- Artículos para el producto 'Leather Jacket'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A031', 'P007', 'Leather Jacket - Talla S', 'S', 'Negro', 25, '#000000', 'Chaqueta de cuero, ideal para la temporada de otoño'),
('A032', 'P007', 'Leather Jacket - Talla M', 'M', 'Café', 20, '#6F4F37', 'Chaqueta de cuero, ideal para la temporada de otoño'),
('A033', 'P007', 'Leather Jacket - Talla L', 'L', 'Negro', 15, '#000000', 'Chaqueta de cuero, ideal para la temporada de otoño'),
('A034', 'P007', 'Leather Jacket - Talla XL', 'XL', 'Café', 12, '#6F4F37', 'Chaqueta de cuero, ideal para la temporada de otoño'),
('A035', 'P007', 'Leather Jacket - Talla XXL', 'XXL', 'Negro', 10, '#000000', 'Chaqueta de cuero, ideal para la temporada de otoño');

-- Artículos para el producto 'Blazer'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A036', 'P008', 'Blazer - Talla S', 'S', 'Azul', 18, '#0000FF', 'Blazer formal con corte ajustado'),
('A037', 'P008', 'Blazer - Talla M', 'M', 'Negro', 15, '#000000', 'Blazer formal con corte ajustado'),
('A038', 'P008', 'Blazer - Talla L', 'L', 'Gris', 12, '#808080', 'Blazer formal con corte ajustado'),
('A039', 'P008', 'Blazer - Talla XL', 'XL', 'Azul', 10, '#0000FF', 'Blazer formal con corte ajustado'),
('A040', 'P008', 'Blazer - Talla XXL', 'XXL', 'Negro', 8, '#000000', 'Blazer formal con corte ajustado');

-- Artículos para el producto 'Evening Dress'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A041', 'P009', 'Evening Dress - Talla S', 'S', 'Rojo', 5, '#FF0000', 'Vestido largo y elegante para eventos formales'),
('A042', 'P009', 'Evening Dress - Talla M', 'M', 'Negro', 6, '#000000', 'Vestido largo y elegante para eventos formales'),
('A043', 'P009', 'Evening Dress - Talla L', 'L', 'Azul', 4, '#0000FF', 'Vestido largo y elegante para eventos formales'),
('A044', 'P009', 'Evening Dress - Talla XL', 'XL', 'Blanco', 3, '#FFFFFF', 'Vestido largo y elegante para eventos formales'),
('A045', 'P009', 'Evening Dress - Talla XXL', 'XXL', 'Rojo', 2, '#FF0000', 'Vestido largo y elegante para eventos formales');

-- Artículos para el producto 'Cocktail Dress'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A046', 'P010', 'Cocktail Dress - Talla S', 'S', 'Negro', 8, '#000000', 'Vestido corto y elegante para cócteles'),
('A047', 'P010', 'Cocktail Dress - Talla M', 'M', 'Rojo', 10, '#FF0000', 'Vestido corto y elegante para cócteles'),
('A048', 'P010', 'Cocktail Dress - Talla L', 'L', 'Azul', 12, '#0000FF', 'Vestido corto y elegante para cócteles'),
('A049', 'P010', 'Cocktail Dress - Talla XL', 'XL', 'Negro', 15, '#000000', 'Vestido corto y elegante para cócteles'),
('A050', 'P010', 'Cocktail Dress - Talla XXL', 'XXL', 'Rojo', 7, '#FF0000', 'Vestido corto y elegante para cócteles');

-- Artículos para el producto 'Day Dress'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A051', 'P011', 'Day Dress - Talla S', 'S', 'Beige', 10, '#F5F5DC', 'Vestido casual para el día a día'),
('A052', 'P011', 'Day Dress - Talla M', 'M', 'Gris', 12, '#808080', 'Vestido casual para el día a día'),
('A053', 'P011', 'Day Dress - Talla L', 'L', 'Azul', 8, '#0000FF', 'Vestido casual para el día a día'),
('A054', 'P011', 'Day Dress - Talla XL', 'XL', 'Blanco', 6, '#FFFFFF', 'Vestido casual para el día a día'),
('A055', 'P011', 'Day Dress - Talla XXL', 'XXL', 'Negro', 5, '#000000', 'Vestido casual para el día a día');

-- Artículos para el producto 'Maxi Dress'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A056', 'P012', 'Maxi Dress - Talla S', 'S', 'Negro', 8, '#000000', 'Vestido largo, ideal para la playa o eventos formales'),
('A057', 'P012', 'Maxi Dress - Talla M', 'M', 'Blanco', 10, '#FFFFFF', 'Vestido largo, ideal para la playa o eventos formales'),
('A058', 'P012', 'Maxi Dress - Talla L', 'L', 'Azul', 12, '#0000FF', 'Vestido largo, ideal para la playa o eventos formales'),
('A059', 'P012', 'Maxi Dress - Talla XL', 'XL', 'Verde', 15, '#008000', 'Vestido largo, ideal para la playa o eventos formales'),
('A060', 'P012', 'Maxi Dress - Talla XXL', 'XXL', 'Rojo', 18, '#FF0000', 'Vestido largo, ideal para la playa o eventos formales');

-- Artículos para el producto 'A-Line Skirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A061', 'P013', 'A-Line Skirt - Talla S', 'S', 'Negro', 10, '#000000', 'Falda de corte A, ideal para todos los días'),
('A062', 'P013', 'A-Line Skirt - Talla M', 'M', 'Rojo', 12, '#FF0000', 'Falda de corte A, ideal para todos los días'),
('A063', 'P013', 'A-Line Skirt - Talla L', 'L', 'Azul', 15, '#0000FF', 'Falda de corte A, ideal para todos los días'),
('A064', 'P013', 'A-Line Skirt - Talla XL', 'XL', 'Verde', 8, '#008000', 'Falda de corte A, ideal para todos los días'),
('A065', 'P013', 'A-Line Skirt - Talla XXL', 'XXL', 'Negro', 6, '#000000', 'Falda de corte A, ideal para todos los días');

-- Artículos para el producto 'Pencil Skirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A066', 'P014', 'Pencil Skirt - Talla S', 'S', 'Negro', 20, '#000000', 'Falda de tubo ajustada para ocasiones formales'),
('A067', 'P014', 'Pencil Skirt - Talla M', 'M', 'Rojo', 18, '#FF0000', 'Falda de tubo ajustada para ocasiones formales'),
('A068', 'P014', 'Pencil Skirt - Talla L', 'L', 'Gris', 15, '#808080', 'Falda de tubo ajustada para ocasiones formales'),
('A069', 'P014', 'Pencil Skirt - Talla XL', 'XL', 'Negro', 12, '#000000', 'Falda de tubo ajustada para ocasiones formales'),
('A070', 'P014', 'Pencil Skirt - Talla XXL', 'XXL', 'Rojo', 10, '#FF0000', 'Falda de tubo ajustada para ocasiones formales');

-- Artículos para el producto 'Pleated Skirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A071', 'P015', 'Pleated Skirt - Talla S', 'S', 'Beige', 12, '#F5F5DC', 'Falda plisada de largo medio'),
('A072', 'P015', 'Pleated Skirt - Talla M', 'M', 'Negro', 15, '#000000', 'Falda plisada de largo medio'),
('A073', 'P015', 'Pleated Skirt - Talla L', 'L', 'Azul', 10, '#0000FF', 'Falda plisada de largo medio'),
('A074', 'P015', 'Pleated Skirt - Talla XL', 'XL', 'Gris', 8, '#808080', 'Falda plisada de largo medio'),
('A075', 'P015', 'Pleated Skirt - Talla XXL', 'XXL', 'Beige', 5, '#F5F5DC', 'Falda plisada de largo medio');

-- Artículos para el producto 'Mini Skirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A076', 'P016', 'Mini Skirt - Talla S', 'S', 'Negro', 10, '#000000', 'Falda corta para un look más casual'),
('A077', 'P016', 'Mini Skirt - Talla M', 'M', 'Rojo', 15, '#FF0000', 'Falda corta para un look más casual'),
('A078', 'P016', 'Mini Skirt - Talla L', 'L', 'Azul', 18, '#0000FF', 'Falda corta para un look más casual'),
('A079', 'P016', 'Mini Skirt - Talla XL', 'XL', 'Verde', 8, '#008000', 'Falda corta para un look más casual'),
('A080', 'P016', 'Mini Skirt - Talla XXL', 'XXL', 'Negro', 6, '#000000', 'Falda corta para un look más casual');

-- Artículos para el producto 'Basic T-Shirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A081', 'P017', 'Basic T-Shirt - Talla S', 'S', 'Blanco', 20, '#FFFFFF', 'Camiseta básica de algodón, cómoda para el día a día'),
('A082', 'P017', 'Basic T-Shirt - Talla M', 'M', 'Negro', 18, '#000000', 'Camiseta básica de algodón, cómoda para el día a día'),
('A083', 'P017', 'Basic T-Shirt - Talla L', 'L', 'Rojo', 15, '#FF0000', 'Camiseta básica de algodón, cómoda para el día a día'),
('A084', 'P017', 'Basic T-Shirt - Talla XL', 'XL', 'Azul', 10, '#0000FF', 'Camiseta básica de algodón, cómoda para el día a día'),
('A085', 'P017', 'Basic T-Shirt - Talla XXL', 'XXL', 'Gris', 8, '#808080', 'Camiseta básica de algodón, cómoda para el día a día');

-- Artículos para el producto 'Graphic T-Shirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A086', 'P018', 'Graphic T-Shirt - Talla S', 'S', 'Blanco', 12, '#FFFFFF', 'Camiseta con diseño gráfico moderno'),
('A087', 'P018', 'Graphic T-Shirt - Talla M', 'M', 'Negro', 14, '#000000', 'Camiseta con diseño gráfico moderno'),
('A088', 'P018', 'Graphic T-Shirt - Talla L', 'L', 'Rojo', 16, '#FF0000', 'Camiseta con diseño gráfico moderno'),
('A089', 'P018', 'Graphic T-Shirt - Talla XL', 'XL', 'Azul', 18, '#0000FF', 'Camiseta con diseño gráfico moderno'),
('A090', 'P018', 'Graphic T-Shirt - Talla XXL', 'XXL', 'Gris', 10, '#808080', 'Camiseta con diseño gráfico moderno');

-- Artículos para el producto 'V-neck T-Shirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A091', 'P019', 'V-neck T-Shirt - Talla S', 'S', 'Blanco', 12, '#FFFFFF', 'Camiseta de cuello en V, ideal para días calurosos'),
('A092', 'P019', 'V-neck T-Shirt - Talla M', 'M', 'Negro', 15, '#000000', 'Camiseta de cuello en V, ideal para días calurosos'),
('A093', 'P019', 'V-neck T-Shirt - Talla L', 'L', 'Rojo', 10, '#FF0000', 'Camiseta de cuello en V, ideal para días calurosos'),
('A094', 'P019', 'V-neck T-Shirt - Talla XL', 'XL', 'Azul', 8, '#0000FF', 'Camiseta de cuello en V, ideal para días calurosos'),
('A095', 'P019', 'V-neck T-Shirt - Talla XXL', 'XXL', 'Gris', 5, '#808080', 'Camiseta de cuello en V, ideal para días calurosos');

-- Artículos para el producto 'Long Sleeve T-Shirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A096', 'P020', 'Long Sleeve T-Shirt - Talla S', 'S', 'Blanco', 14, '#FFFFFF', 'Camiseta de manga larga, perfecta para el otoño'),
('A097', 'P020', 'Long Sleeve T-Shirt - Talla M', 'M', 'Negro', 16, '#000000', 'Camiseta de manga larga, perfecta para el otoño'),
('A098', 'P020', 'Long Sleeve T-Shirt - Talla L', 'L', 'Rojo', 10, '#FF0000', 'Camiseta de manga larga, perfecta para el otoño'),
('A099', 'P020', 'Long Sleeve T-Shirt - Talla XL', 'XL', 'Azul', 8, '#0000FF', 'Camiseta de manga larga, perfecta para el otoño'),
('A100', 'P020', 'Long Sleeve T-Shirt - Talla XXL', 'XXL', 'Gris', 6, '#808080', 'Camiseta de manga larga, perfecta para el otoño');

-- Artículos para el producto 'Body Top'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A101', 'P021', 'Body Top - Talla S', 'S', 'Negro', 12, '#000000', 'Top de cuerpo ajustado, ideal para combinar con faldas'),
('A102', 'P021', 'Body Top - Talla M', 'M', 'Blanco', 15, '#FFFFFF', 'Top de cuerpo ajustado, ideal para combinar con faldas'),
('A103', 'P021', 'Body Top - Talla L', 'L', 'Rojo', 10, '#FF0000', 'Top de cuerpo ajustado, ideal para combinar con faldas'),
('A104', 'P021', 'Body Top - Talla XL', 'XL', 'Azul', 8, '#0000FF', 'Top de cuerpo ajustado, ideal para combinar con faldas'),
('A105', 'P021', 'Body Top - Talla XXL', 'XXL', 'Gris', 6, '#808080', 'Top de cuerpo ajustado, ideal para combinar con faldas');

-- Artículos para el producto 'Crop Top'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A106', 'P022', 'Crop Top - Talla S', 'S', 'Negro', 18, '#000000', 'Top corto, muy de moda'),
('A107', 'P022', 'Crop Top - Talla M', 'M', 'Blanco', 20, '#FFFFFF', 'Top corto, muy de moda'),
('A108', 'P022', 'Crop Top - Talla L', 'L', 'Rojo', 15, '#FF0000', 'Top corto, muy de moda'),
('A109', 'P022', 'Crop Top - Talla XL', 'XL', 'Azul', 10, '#0000FF', 'Top corto, muy de moda'),
('A110', 'P022', 'Crop Top - Talla XXL', 'XXL', 'Gris', 8, '#808080', 'Top corto, muy de moda');

-- Artículos para el producto 'Blouse'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A111', 'P023', 'Blouse - Talla S', 'S', 'Blanco', 10, '#FFFFFF', 'Blusa elegante para ocasiones formales'),
('A112', 'P023', 'Blouse - Talla M', 'M', 'Negro', 12, '#000000', 'Blusa elegante para ocasiones formales'),
('A113', 'P023', 'Blouse - Talla L', 'L', 'Rojo', 15, '#FF0000', 'Blusa elegante para ocasiones formales'),
('A114', 'P023', 'Blouse - Talla XL', 'XL', 'Azul', 8, '#0000FF', 'Blusa elegante para ocasiones formales'),
('A115', 'P023', 'Blouse - Talla XXL', 'XXL', 'Gris', 6, '#808080', 'Blusa elegante para ocasiones formales');

-- Artículos para el producto 'Tank Top'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A116', 'P024', 'Tank Top - Talla S', 'S', 'Negro', 18, '#000000', 'Top sin mangas, ideal para el verano'),
('A117', 'P024', 'Tank Top - Talla M', 'M', 'Blanco', 20, '#FFFFFF', 'Top sin mangas, ideal para el verano'),
('A118', 'P024', 'Tank Top - Talla L', 'L', 'Rojo', 15, '#FF0000', 'Top sin mangas, ideal para el verano'),
('A119', 'P024', 'Tank Top - Talla XL', 'XL', 'Azul', 10, '#0000FF', 'Top sin mangas, ideal para el verano'),
('A120', 'P024', 'Tank Top - Talla XXL', 'XXL', 'Gris', 6, '#808080', 'Top sin mangas, ideal para el verano');

-- Artículos para el producto 'Slim Fit Jeans'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A121', 'P025', 'Slim Fit Jeans - Talla S', 'S', 'Azul', 10, '#0000FF', 'Jeans de corte ajustado, ideal para el día a día'),
('A122', 'P025', 'Slim Fit Jeans - Talla M', 'M', 'Negro', 12, '#000000', 'Jeans de corte ajustado, ideal para el día a día'),
('A123', 'P025', 'Slim Fit Jeans - Talla L', 'L', 'Gris', 15, '#808080', 'Jeans de corte ajustado, ideal para el día a día'),
('A124', 'P025', 'Slim Fit Jeans - Talla XL', 'XL', 'Azul Claro', 8, '#ADD8E6', 'Jeans de corte ajustado, ideal para el día a día'),
('A125', 'P025', 'Slim Fit Jeans - Talla XXL', 'XXL', 'Oscuro', 6, '#2F4F4F', 'Jeans de corte ajustado, ideal para el día a día');

-- Artículos para el producto 'Bootcut Jeans'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A126', 'P026', 'Bootcut Jeans - Talla S', 'S', 'Azul', 8, '#0000FF', 'Jeans de corte acampanado'),
('A127', 'P026', 'Bootcut Jeans - Talla M', 'M', 'Negro', 10, '#000000', 'Jeans de corte acampanado'),
('A128', 'P026', 'Bootcut Jeans - Talla L', 'L', 'Gris', 12, '#808080', 'Jeans de corte acampanado'),
('A129', 'P026', 'Bootcut Jeans - Talla XL', 'XL', 'Azul Claro', 6, '#ADD8E6', 'Jeans de corte acampanado'),
('A130', 'P026', 'Bootcut Jeans - Talla XXL', 'XXL', 'Oscuro', 4, '#2F4F4F', 'Jeans de corte acampanado');

-- Artículos para el producto 'Chinos'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A131', 'P027', 'Chinos - Talla S', 'S', 'Beige', 20, '#F5F5DC', 'Pantalones chinos, versátiles y cómodos'),
('A132', 'P027', 'Chinos - Talla M', 'M', 'Negro', 18, '#000000', 'Pantalones chinos, versátiles y cómodos'),
('A133', 'P027', 'Chinos - Talla L', 'L', 'Verde', 15, '#008000', 'Pantalones chinos, versátiles y cómodos'),
('A134', 'P027', 'Chinos - Talla XL', 'XL', 'Azul', 10, '#0000FF', 'Pantalones chinos, versátiles y cómodos'),
('A135', 'P027', 'Chinos - Talla XXL', 'XXL', 'Gris', 8, '#808080', 'Pantalones chinos, versátiles y cómodos');

-- Artículos para el producto 'Dress Trousers'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A136', 'P028', 'Dress Trousers - Talla S', 'S', 'Negro', 10, '#000000', 'Pantalones de vestir, adecuados para eventos formales'),
('A137', 'P028', 'Dress Trousers - Talla M', 'M', 'Gris', 12, '#808080', 'Pantalones de vestir, adecuados para eventos formales'),
('A138', 'P028', 'Dress Trousers - Talla L', 'L', 'Beige', 15, '#F5F5DC', 'Pantalones de vestir, adecuados para eventos formales'),
('A139', 'P028', 'Dress Trousers - Talla XL', 'XL', 'Azul Marino', 8, '#000080', 'Pantalones de vestir, adecuados para eventos formales'),
('A140', 'P028', 'Dress Trousers - Talla XXL', 'XXL', 'Negro', 6, '#000000', 'Pantalones de vestir, adecuados para eventos formales');

-- Artículos para el producto 'Knit Sweater'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A141', 'P029', 'Knit Sweater - Talla S', 'S', 'Azul', 10, '#0000FF', 'Suéter de punto suave, ideal para el invierno'),
('A142', 'P029', 'Knit Sweater - Talla M', 'M', 'Gris', 12, '#808080', 'Suéter de punto suave, ideal para el invierno'),
('A143', 'P029', 'Knit Sweater - Talla L', 'L', 'Negro', 15, '#000000', 'Suéter de punto suave, ideal para el invierno'),
('A144', 'P029', 'Knit Sweater - Talla XL', 'XL', 'Rojo', 8, '#FF0000', 'Suéter de punto suave, ideal para el invierno'),
('A145', 'P029', 'Knit Sweater - Talla XXL', 'XXL', 'Azul Marino', 6, '#000080', 'Suéter de punto suave, ideal para el invierno');

-- Artículos para el producto 'Cashmere Sweater'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A146', 'P030', 'Cashmere Sweater - Talla S', 'S', 'Beige', 8, '#F5F5DC', 'Suéter de cachemira de alta calidad'),
('A147', 'P030', 'Cashmere Sweater - Talla M', 'M', 'Blanco', 10, '#FFFFFF', 'Suéter de cachemira de alta calidad'),
('A148', 'P030', 'Cashmere Sweater - Talla L', 'L', 'Negro', 12, '#000000', 'Suéter de cachemira de alta calidad'),
('A149', 'P030', 'Cashmere Sweater - Talla XL', 'XL', 'Gris', 6, '#808080', 'Suéter de cachemira de alta calidad'),
('A150', 'P030', 'Cashmere Sweater - Talla XXL', 'XXL', 'Rojo', 5, '#FF0000', 'Suéter de cachemira de alta calidad');

-- Artículos para el producto 'Cardigan'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A151', 'P031', 'Cardigan - Talla S', 'S', 'Negro', 8, '#000000', 'Cárdigan largo, cómodo para el otoño'),
('A152', 'P031', 'Cardigan - Talla M', 'M', 'Gris', 10, '#808080', 'Cárdigan largo, cómodo para el otoño'),
('A153', 'P031', 'Cardigan - Talla L', 'L', 'Beige', 12, '#F5F5DC', 'Cárdigan largo, cómodo para el otoño'),
('A154', 'P031', 'Cardigan - Talla XL', 'XL', 'Rojo', 6, '#FF0000', 'Cárdigan largo, cómodo para el otoño'),
('A155', 'P031', 'Cardigan - Talla XXL', 'XXL', 'Azul', 4, '#0000FF', 'Cárdigan largo, cómodo para el otoño');

-- Artículos para el producto 'Turtleneck Sweater'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A156', 'P032', 'Turtleneck Sweater - Talla S', 'S', 'Negro', 8, '#000000', 'Suéter de cuello alto, ideal para el invierno'),
('A157', 'P032', 'Turtleneck Sweater - Talla M', 'M', 'Gris', 10, '#808080', 'Suéter de cuello alto, ideal para el invierno'),
('A158', 'P032', 'Turtleneck Sweater - Talla L', 'L', 'Rojo', 12, '#FF0000', 'Suéter de cuello alto, ideal para el invierno'),
('A159', 'P032', 'Turtleneck Sweater - Talla XL', 'XL', 'Azul Marino', 6, '#000080', 'Suéter de cuello alto, ideal para el invierno'),
('A160', 'P032', 'Turtleneck Sweater - Talla XXL', 'XXL', 'Beige', 5, '#F5F5DC', 'Suéter de cuello alto, ideal para el invierno');

-- Artículos para el producto 'Hoodie Sweatshirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A161', 'P033', 'Hoodie Sweatshirt - Talla S', 'S', 'Negro', 10, '#000000', 'Sudadera con capucha, cómoda y deportiva'),
('A162', 'P033', 'Hoodie Sweatshirt - Talla M', 'M', 'Azul', 12, '#0000FF', 'Sudadera con capucha, cómoda y deportiva'),
('A163', 'P033', 'Hoodie Sweatshirt - Talla L', 'L', 'Gris', 15, '#808080', 'Sudadera con capucha, cómoda y deportiva'),
('A164', 'P033', 'Hoodie Sweatshirt - Talla XL', 'XL', 'Rojo', 8, '#FF0000', 'Sudadera con capucha, cómoda y deportiva'),
('A165', 'P033', 'Hoodie Sweatshirt - Talla XXL', 'XXL', 'Verde', 6, '#008000', 'Sudadera con capucha, cómoda y deportiva');

-- Artículos para el producto 'Crewneck Sweatshirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A166', 'P034', 'Crewneck Sweatshirt - Talla S', 'S', 'Negro', 15, '#000000', 'Sudadera de cuello redondo'),
('A167', 'P034', 'Crewneck Sweatshirt - Talla M', 'M', 'Gris', 12, '#808080', 'Sudadera de cuello redondo'),
('A168', 'P034', 'Crewneck Sweatshirt - Talla L', 'L', 'Azul', 10, '#0000FF', 'Sudadera de cuello redondo'),
('A169', 'P034', 'Crewneck Sweatshirt - Talla XL', 'XL', 'Rojo', 8, '#FF0000', 'Sudadera de cuello redondo'),
('A170', 'P034', 'Crewneck Sweatshirt - Talla XXL', 'XXL', 'Verde', 6, '#008000', 'Sudadera de cuello redondo');

-- Artículos para el producto 'Zip-up Sweatshirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A171', 'P035', 'Zip-up Sweatshirt - Talla S', 'S', 'Negro', 18, '#000000', 'Sudadera con cremallera, fácil de poner y quitar'),
('A172', 'P035', 'Zip-up Sweatshirt - Talla M', 'M', 'Azul', 20, '#0000FF', 'Sudadera con cremallera, fácil de poner y quitar'),
('A173', 'P035', 'Zip-up Sweatshirt - Talla L', 'L', 'Gris', 15, '#808080', 'Sudadera con cremallera, fácil de poner y quitar'),
('A174', 'P035', 'Zip-up Sweatshirt - Talla XL', 'XL', 'Rojo', 12, '#FF0000', 'Sudadera con cremallera, fácil de poner y quitar'),
('A175', 'P035', 'Zip-up Sweatshirt - Talla XXL', 'XXL', 'Verde', 8, '#008000', 'Sudadera con cremallera, fácil de poner y quitar');


-- Artículos para el producto 'Fleece Sweatshirt'
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A176', 'P036', 'Fleece Sweatshirt - Talla S', 'S', 'Azul', 10, '#0000FF', 'Sudadera de forro polar, muy abrigada'),
('A177', 'P036', 'Fleece Sweatshirt - Talla M', 'M', 'Gris', 12, '#808080', 'Sudadera de forro polar, muy abrigada'),
('A178', 'P036', 'Fleece Sweatshirt - Talla L', 'L', 'Negro', 15, '#000000', 'Sudadera de forro polar, muy abrigada'),
('A179', 'P036', 'Fleece Sweatshirt - Talla XL', 'XL', 'Rojo', 8, '#FF0000', 'Sudadera de forro polar, muy abrigada'),
('A180', 'P036', 'Fleece Sweatshirt - Talla XXL', 'XXL', 'Verde', 5, '#008000', 'Sudadera de forro polar, muy abrigada');

-- Insertar artículos para Totes
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A181', 'P037', 'Tote Bag Classic - Black', 'Única', 'Negro', 10, '#000000', 'Bolso grande con estilo clásico'),
('A182', 'P037', 'Tote Bag Classic - Beige', 'Única', 'Beige', 15, '#F5F5DC', 'Bolso grande con estilo clásico'),
('A183', 'P038', 'Tote Bag Modern - Red', 'Única', 'Rojo', 12, '#FF0000', 'Bolso moderno con gran capacidad'),
('A184', 'P038', 'Tote Bag Modern - Grey', 'Única', 'Gris', 8, '#808080', 'Bolso moderno con gran capacidad');

-- Insertar artículos para Boots
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A185', 'P041', 'Leather Boots - Black', '42', 'Negro', 5, '#000000', 'Botas de cuero elegantes y duraderas'),
('A186', 'P041', 'Leather Boots - Brown', '44', 'Marrón', 4, '#A52A2A', 'Botas de cuero elegantes y duraderas'),
('A187', 'P042', 'Suede Boots - Grey', '40', 'Gris', 8, '#808080', 'Botas de ante cómodas y modernas'),
('A188', 'P042', 'Suede Boots - Beige', '43', 'Beige', 6, '#F5F5DC', 'Botas de ante cómodas y modernas');

-- Insertar artículos para Sneakers
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A189', 'P043', 'Sporty Sneakers - White', '41', 'Blanco', 10, '#FFFFFF', 'Zapatillas deportivas modernas'),
('A190', 'P043', 'Sporty Sneakers - Black', '42', 'Negro', 15, '#000000', 'Zapatillas deportivas modernas'),
('A191', 'P044', 'Casual Sneakers - Blue', '39', 'Azul', 12, '#0000FF', 'Zapatillas casuales para todos los días'),
('A192', 'P044', 'Casual Sneakers - Grey', '44', 'Gris', 10, '#808080', 'Zapatillas casuales para todos los días');

-- Insertar artículos para Clutches
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A193', 'P039', 'Leather Clutch - Brown', 'Única', 'Marrón', 8, '#A52A2A', 'Clutch de cuero elegante y funcional'),
('A194', 'P039', 'Leather Clutch - Black', 'Única', 'Negro', 10, '#000000', 'Clutch de cuero elegante y funcional'),
('A195', 'P040', 'Silk Clutch - Blue', 'Única', 'Azul', 6, '#0000FF', 'Clutch de seda elegante y sofisticado'),
('A196', 'P040', 'Silk Clutch - White', 'Única', 'Blanco', 12, '#FFFFFF', 'Clutch de seda elegante y sofisticado');

-- Insertar artículos para Watches
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A197', 'P045', 'Leather Strap Watch - Brown', 'Única', 'Marrón', 6, '#A52A2A', 'Reloj con correa de cuero marrón'),
('A198', 'P045', 'Leather Strap Watch - Black', 'Única', 'Negro', 8, '#000000', 'Reloj con correa de cuero negro'),
('A199', 'P046', 'Metal Strap Watch - Silver', 'Única', 'Plata', 10, '#C0C0C0', 'Reloj con correa metálica plateada'),
('A200', 'P046', 'Metal Strap Watch - Gold', 'Única', 'Dorado', 4, '#FFD700', 'Reloj con correa metálica dorada');

-- Insertar artículos para Hats
INSERT INTO articulos (id_articulo, id_producto, nombre, talla, color, stock, codigo_color, descripcion) VALUES
('A201', 'P047', 'Fedora Hat - Black', 'Única', 'Negro', 10, '#000000', 'Sombrero fedora elegante de ala ancha'),
('A202', 'P047', 'Fedora Hat - Grey', 'Única', 'Gris', 7, '#808080', 'Sombrero fedora elegante de ala ancha'),
('A203', 'P048', 'Beanie Hat - Red', 'Única', 'Rojo', 8, '#FF0000', 'Sombrero de lana tipo beanie para invierno'),
('A204', 'P048', 'Beanie Hat - Blue', 'Única', 'Azul', 12, '#0000FF', 'Sombrero de lana tipo beanie para invierno');










INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A001', 1),  -- Alquilado, Nuevo
('A001', 4),
('A002', 2),  -- Retirado, Algo Usado
('A002', 5),
('A003', 3),  -- Disponible, Usado
('A003', 6),
('A004', 1),  -- Alquilado, Mal Estado
('A004', 7),
('A005', 2),  -- Retirado, Nuevo
('A005', 4),
('A006', 3),  -- Disponible, Algo Usado
('A006', 5),
('A007', 1),  -- Alquilado, Usado
('A007', 6),
('A008', 2),  -- Retirado, Mal Estado
('A008', 7),
('A009', 3),  -- Disponible, Nuevo
('A009', 4),
('A010', 1),  -- Alquilado, Algo Usado
('A010', 5),
('A011', 2),  -- Retirado, Usado
('A011', 6),
('A012', 3),  -- Disponible, Mal Estado
('A012', 7),
('A013', 1),  -- Alquilado, Nuevo
('A013', 4),
('A014', 2),  -- Retirado, Algo Usado
('A014', 5),
('A015', 3),  -- Disponible, Usado
('A015', 6),
('A016', 1),  -- Alquilado, Mal Estado
('A016', 7),
('A017', 2),  -- Retirado, Nuevo
('A017', 4),
('A018', 3),  -- Disponible, Algo Usado
('A018', 5),
('A019', 1),  -- Alquilado, Usado
('A019', 6),
('A020', 2),  -- Retirado, Mal Estado
('A020', 7),
('A021', 3),  -- Disponible, Nuevo
('A021', 4),
('A022', 1),  -- Alquilado, Algo Usado
('A022', 5),
('A023', 2),  -- Retirado, Usado
('A023', 6),
('A024', 3),  -- Disponible, Mal Estado
('A024', 7),
('A025', 1),  -- Alquilado, Nuevo
('A025', 4),
('A026', 2),  -- Retirado, Algo Usado
('A026', 5),
('A027', 3),  -- Disponible, Usado
('A027', 6),
('A028', 1),  -- Alquilado, Mal Estado
('A028', 7),
('A029', 2),  -- Retirado, Nuevo
('A029', 4),
('A030', 3),  -- Disponible, Algo Usado
('A030', 5),
('A031', 1),  -- Alquilado, Usado
('A031', 6),
('A032', 2),  -- Retirado, Mal Estado
('A032', 7),
('A033', 3),  -- Disponible, Nuevo
('A033', 4),
('A034', 1),  -- Alquilado, Algo Usado
('A034', 5),
('A035', 2),  -- Retirado, Usado
('A035', 6),
('A036', 3),  -- Disponible, Mal Estado
('A036', 7);

INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A037', 1),  -- Alquilado, Nuevo
('A037', 4),
('A038', 2),  -- Retirado, Algo Usado
('A038', 5),
('A039', 3),  -- Disponible, Usado
('A039', 6),
('A040', 1),  -- Alquilado, Mal Estado
('A040', 7),
('A041', 2),  -- Retirado, Nuevo
('A041', 4),
('A042', 3),  -- Disponible, Algo Usado
('A042', 5),
('A043', 1),  -- Alquilado, Usado
('A043', 6),
('A044', 2),  -- Retirado, Mal Estado
('A044', 7),
('A045', 3),  -- Disponible, Nuevo
('A045', 4),
('A046', 1),  -- Alquilado, Algo Usado
('A046', 5),
('A047', 2),  -- Retirado, Usado
('A047', 6),
('A048', 3),  -- Disponible, Mal Estado
('A048', 7),
('A049', 1),  -- Alquilado, Nuevo
('A049', 4),
('A050', 2),  -- Retirado, Algo Usado
('A050', 5),
('A051', 3),  -- Disponible, Usado
('A051', 6),
('A052', 1),  -- Alquilado, Mal Estado
('A052', 7),
('A053', 2),  -- Retirado, Nuevo
('A053', 4),
('A054', 3),  -- Disponible, Algo Usado
('A054', 5),
('A055', 1),  -- Alquilado, Usado
('A055', 6),
('A056', 2),  -- Retirado, Mal Estado
('A056', 7),
('A057', 3),  -- Disponible, Nuevo
('A057', 4),
('A058', 1),  -- Alquilado, Algo Usado
('A058', 5),
('A059', 2),  -- Retirado, Usado
('A059', 6),
('A060', 3),  -- Disponible, Mal Estado
('A060', 7),
('A061', 1),  -- Alquilado, Nuevo
('A061', 4),
('A062', 2),  -- Retirado, Algo Usado
('A062', 5),
('A063', 3),  -- Disponible, Usado
('A063', 6),
('A064', 1),  -- Alquilado, Mal Estado
('A064', 7),
('A065', 2),  -- Retirado, Nuevo
('A065', 4),
('A066', 3),  -- Disponible, Algo Usado
('A066', 5),
('A067', 1),  -- Alquilado, Usado
('A067', 6),
('A068', 2),  -- Retirado, Mal Estado
('A068', 7),
('A069', 3),  -- Disponible, Nuevo
('A069', 4),
('A070', 1),  -- Alquilado, Algo Usado
('A070', 5),
('A071', 2),  -- Retirado, Usado
('A071', 6),
('A072', 3),  -- Disponible, Mal Estado
('A072', 7),
('A073', 1),  -- Alquilado, Nuevo
('A073', 4),
('A074', 2),  -- Retirado, Algo Usado
('A074', 5),
('A075', 3),  -- Disponible, Usado
('A075', 6),
('A076', 1),  -- Alquilado, Mal Estado
('A076', 7),
('A077', 2),  -- Retirado, Nuevo
('A077', 4),
('A078', 3),  -- Disponible, Algo Usado
('A078', 5),
('A079', 1),  -- Alquilado, Usado
('A079', 6),
('A080', 2),  -- Retirado, Mal Estado
('A080', 7),
('A081', 3),  -- Disponible, Nuevo
('A081', 4),
('A082', 1),  -- Alquilado, Algo Usado
('A082', 5),
('A083', 2),  -- Retirado, Usado
('A083', 6),
('A084', 3),  -- Disponible, Mal Estado
('A084', 7),
('A085', 1),  -- Alquilado, Nuevo
('A085', 4),
('A086', 2),  -- Retirado, Algo Usado
('A086', 5),
('A087', 3),  -- Disponible, Usado
('A087', 6),
('A088', 1),  -- Alquilado, Mal Estado
('A088', 7),
('A089', 2),  -- Retirado, Nuevo
('A089', 4),
('A090', 3),  -- Disponible, Algo Usado
('A090', 5),
('A091', 1),  -- Alquilado, Usado
('A091', 6),
('A092', 2),  -- Retirado, Mal Estado
('A092', 7),
('A093', 3),  -- Disponible, Nuevo
('A093', 4),
('A094', 1),  -- Alquilado, Algo Usado
('A094', 5),
('A095', 2),  -- Retirado, Usado
('A095', 6),
('A096', 3),  -- Disponible, Mal Estado
('A096', 7);

INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A097', 3),  -- Disponible, Algo Usado
('A097', 5),
('A098', 1),  -- Alquilado, Usado
('A098', 6),
('A099', 2),  -- Retirado, Mal Estado
('A099', 7),
('A100', 3),  -- Disponible, Nuevo
('A100', 4),
('A101', 1),  -- Alquilado, Algo Usado
('A101', 5),
('A102', 2),  -- Retirado, Usado
('A102', 6),
('A103', 3),  -- Disponible, Mal Estado
('A103', 7),
('A104', 1),  -- Alquilado, Nuevo
('A104', 4),
('A105', 2),  -- Retirado, Algo Usado
('A105', 5),
('A106', 3),  -- Disponible, Usado
('A106', 6),
('A107', 1),  -- Alquilado, Mal Estado
('A107', 7),
('A108', 2),  -- Retirado, Nuevo
('A108', 4),
('A109', 3),  -- Disponible, Algo Usado
('A109', 5),
('A110', 1),  -- Alquilado, Usado
('A110', 6),
('A111', 2),  -- Retirado, Mal Estado
('A111', 7),
('A112', 3),  -- Disponible, Nuevo
('A112', 4),
('A113', 1),  -- Alquilado, Algo Usado
('A113', 5),
('A114', 2),  -- Retirado, Usado
('A114', 6),
('A115', 3),  -- Disponible, Mal Estado
('A115', 7),
('A116', 1),  -- Alquilado, Nuevo
('A116', 4),
('A117', 2),  -- Retirado, Algo Usado
('A117', 5),
('A118', 3),  -- Disponible, Usado
('A118', 6),
('A119', 1),  -- Alquilado, Mal Estado
('A119', 7),
('A120', 2),  -- Retirado, Nuevo
('A120', 4),
('A121', 3),  -- Disponible, Algo Usado
('A121', 5),
('A122', 1),  -- Alquilado, Usado
('A122', 6),
('A123', 2),  -- Retirado, Mal Estado
('A123', 7),
('A124', 3),  -- Disponible, Nuevo
('A124', 4),
('A125', 1),  -- Alquilado, Algo Usado
('A125', 5),
('A126', 2),  -- Retirado, Usado
('A126', 6),
('A127', 3),  -- Disponible, Mal Estado
('A127', 7),
('A128', 1),  -- Alquilado, Nuevo
('A128', 4),
('A129', 2),  -- Retirado, Algo Usado
('A129', 5),
('A130', 3),  -- Disponible, Usado
('A130', 6),
('A131', 1),  -- Alquilado, Mal Estado
('A131', 7),
('A132', 2),  -- Retirado, Nuevo
('A132', 4),
('A133', 3),  -- Disponible, Algo Usado
('A133', 5),
('A134', 1),  -- Alquilado, Usado
('A134', 6),
('A135', 2),  -- Retirado, Mal Estado
('A135', 7),
('A136', 3),  -- Disponible, Nuevo
('A136', 4),
('A137', 1),  -- Alquilado, Algo Usado
('A137', 5),
('A138', 2),  -- Retirado, Usado
('A138', 6),
('A139', 3),  -- Disponible, Mal Estado
('A139', 7),
('A140', 1),  -- Alquilado, Nuevo
('A140', 4),
('A141', 2),  -- Retirado, Algo Usado
('A141', 5),
('A142', 3),  -- Disponible, Usado
('A142', 6),
('A143', 1),  -- Alquilado, Mal Estado
('A143', 7),
('A144', 2),  -- Retirado, Nuevo
('A144', 4),
('A145', 3),  -- Disponible, Algo Usado
('A145', 5),
('A146', 1),  -- Alquilado, Usado
('A146', 6),
('A147', 2),  -- Retirado, Mal Estado
('A147', 7),
('A148', 3),  -- Disponible, Nuevo
('A148', 4),
('A149', 1),  -- Alquilado, Algo Usado
('A149', 5),
('A150', 2),  -- Retirado, Usado
('A150', 6),
('A151', 3),  -- Disponible, Mal Estado
('A151', 7),
('A152', 1),  -- Alquilado, Nuevo
('A152', 4),
('A153', 2),  -- Retirado, Algo Usado
('A153', 5),
('A154', 3),  -- Disponible, Usado
('A154', 6),
('A155', 1),  -- Alquilado, Mal Estado
('A155', 7),
('A156', 2),  -- Retirado, Nuevo
('A156', 4),
('A157', 3),  -- Disponible, Algo Usado
('A157', 5),
('A158', 1),  -- Alquilado, Usado
('A158', 6),
('A159', 2),  -- Retirado, Mal Estado
('A159', 7),
('A160', 3),  -- Disponible, Nuevo
('A160', 4),
('A161', 1),  -- Alquilado, Algo Usado
('A161', 5),
('A162', 2),  -- Retirado, Usado
('A162', 6),
('A163', 3),  -- Disponible, Mal Estado
('A163', 7),
('A164', 1),  -- Alquilado, Nuevo
('A164', 4),
('A165', 2),  -- Retirado, Algo Usado
('A165', 5),
('A166', 3),  -- Disponible, Usado
('A166', 6),
('A167', 1),  -- Alquilado, Mal Estado
('A167', 7),
('A168', 2),  -- Retirado, Nuevo
('A168', 4),
('A169', 3),  -- Disponible, Algo Usado
('A169', 5),
('A170', 1),  -- Alquilado, Usado
('A170', 6),
('A171', 2),  -- Retirado, Mal Estado
('A171', 7),
('A172', 3),  -- Disponible, Nuevo
('A172', 4),
('A173', 1),  -- Alquilado, Algo Usado
('A173', 5),
('A174', 2),  -- Retirado, Usado
('A174', 6),
('A175', 3),  -- Disponible, Mal Estado
('A175', 7),
('A176', 1),  -- Alquilado, Nuevo
('A176', 4),
('A177', 2),  -- Retirado, Algo Usado
('A177', 5),
('A178', 3),  -- Disponible, Usado
('A178', 6),
('A179', 1),  -- Alquilado, Mal Estado
('A179', 7),
('A180', 2);  -- Retirado, Nuevo

-- Insertar estados para Totes
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A181', 1),  -- Alquilado
('A182', 3),  -- Disponible
('A183', 1),  -- Alquilado
('A184', 2);  -- Retirado

-- Insertar estados para Boots
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A185', 5),  -- Algo Usado
('A186', 4),  -- Nuevo
('A187', 6),  -- Usado
('A188', 7);  -- Mal Estado

-- Insertar estados para Sneakers
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A189', 4),  -- Nuevo
('A190', 3),  -- Disponible
('A191', 5),  -- Algo Usado
('A192', 6);  -- Usado

-- Insertar estados para Clutches
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A193', 1),  -- Alquilado
('A194', 7),  -- Mal Estado
('A195', 2),  -- Retirado
('A196', 3);  -- Disponible

-- Insertar estados para Watches
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A197', 3),  -- Disponible
('A198', 6),  -- Usado
('A199', 4),  -- Nuevo
('A200', 5);  -- Algo Usado

-- Insertar estados para Hats
INSERT INTO articulos_con_estados (id_articulo, id_estado) VALUES
('A201', 4),  -- Nuevo
('A202', 5),  -- Algo Usado
('A203', 6),  -- Usado
('A204', 2);  -- Retirado

INSERT INTO usuarios (id_usuario, username, firstname, lastname, password, email, direccion, sexo, telefono, role) VALUES
(1, 'pacoPalo', 'Paco', 'Palotes', '$10$HyvftGdCO8VVa83uYq6hB.V6h1d9USrHDe2ty7iNM69euCsgSIm4i', 'pacoP@gmail.com', 'madrid', 'H', '694467818', 'USER');

INSERT INTO pedidos (id_pedido, id_usuario, descripcion, fecha, estado, fecha_entrega) VALUES
('P001', 1, 'blabla', '2025-02-10','COMPLETADO', '2025-02-16'),
('P002', 1, 'blabla', '2025-01-22','ENTREGADO', '2025-02-02'),
('P003', 1, 'blabla', '2025-02-28','CARRITO', NULL);

-- Insertar datos en la tabla articulos_en_pedidos (relación de artículos con pedidos)
INSERT INTO articulos_en_pedidos (id_articulo, id_pedido, cantidad, cantidad_devuelta, estado, dias_alquiler, fecha_devuelta) VALUES
('A002', 'P002', 1, 0, 'Alquilado', 6, NULL),  -- Alquilado
('A003', 'P003', 2, 0, 'Disponible', 4, NULL),  -- En el carrito
('A001', 'P002', 1, 0, 'Alquilado', 7, NULL),  -- Alquilado
('A005', 'P003', 2, 0, 'Disponible', 5, NULL),  -- En el carrito
('A002', 'P003', 1, 0, 'Disponible', 4, NULL),  -- En el carrito
('A004', 'P002', 3, 0, 'Alquilado', 2, NULL);  -- Alquilado

-- Insertar datos en la tabla articulos_en_pedidos con artículos devueltos
INSERT INTO articulos_en_pedidos (id_articulo, id_pedido, cantidad, cantidad_devuelta, estado, dias_alquiler, fecha_devuelta) VALUES
('A001', 'P001', 1, 1, 'Devuelto', 3, '2025-02-22'),  -- Alquilado y devuelto
('A002', 'P001', 1, 1, 'Devuelto', 5, '2025-03-02'),  -- Alquilado y devuelto
('A005', 'P001', 1, 1, 'Devuelto', 6, '2025-03-02');  -- Alquilado y devuelto
