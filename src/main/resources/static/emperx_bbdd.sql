-- Creación base de datos
create database emperx_bbdd;
use emperx_bbdd;

-- Creación de las tablas

-- Tabla de Estados
CREATE TABLE estados (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Tabla de Categorias
CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Tabla de Subcategorias
CREATE TABLE subcategorias (
    id_subcategoria INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);

-- Tabla de Productos
CREATE TABLE productos (
    id_producto VARCHAR(255) PRIMARY KEY,
    id_subcategoria INT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    marca VARCHAR(255),
    FOREIGN KEY (id_subcategoria) REFERENCES Subcategorias(id_subcategoria)
);

-- Tabla de Usuarios
CREATE TABLE usuarios (
    id_usuario VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    direccion TEXT,
    sexo ENUM('M', 'F'),
    telefono VARCHAR(20),
    CONSTRAINT chk_sexo CHECK (sexo IN ('M', 'F'))
);

-- Tabla de Perfiles
CREATE TABLE perfiles (
    id_perfil INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Tabla de Usuario_con_Perfiles
CREATE TABLE usuario_con_perfiles (
    id_usuario VARCHAR(255),
    id_perfil INT,
    PRIMARY KEY (id_usuario, id_perfil),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_perfil) REFERENCES Perfiles(id_perfil) ON DELETE CASCADE
);

-- Tabla de Pedidos
CREATE TABLE pedidos (
    id_pedido VARCHAR(255) PRIMARY KEY,
    id_usuario VARCHAR(255),
    descripcion TEXT,
    fecha DATE,
    estado ENUM('Carrito', 'Pagado', 'Entregado', 'Completado') NOT NULL,
    fecha_entrega DATE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
	CONSTRAINT chk_estadopedido CHECK (estado IN ('Carrito', 'Pagado', 'Entregado', 'Completado'))
);

-- Tabla de Articulo
CREATE TABLE articulos (
    id_articulo VARCHAR(255) PRIMARY KEY,
    id_producto VARCHAR(255),
    nombre VARCHAR(255) NOT NULL,
    talla VARCHAR(50),
    color VARCHAR(50),
    stock INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

CREATE TABLE articulos_con_estados (
    id_articulo VARCHAR(255) NOT NULL,
    id_estado INT NOT NULL,
    PRIMARY KEY (id_articulo, id_estado),
    FOREIGN KEY (id_articulo) REFERENCES articulos(id_articulo),
    FOREIGN KEY (id_estado) REFERENCES estados(id_estado)
);

CREATE TABLE articulos_en_pedidos (
    id_articulo VARCHAR(255) NOT NULL,
    id_pedido VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    cantidad_devuelta INT DEFAULT 0,
    estado VARCHAR(255),
    fecha_devuelta DATE,
    PRIMARY KEY (id_articulo, id_pedido),  -- Esto corresponde a la clave compuesta de ArticulosEnPedidoId
    CONSTRAINT fk_articulo FOREIGN KEY (id_articulo) REFERENCES articulos(id_articulo),  -- Asumiendo que la tabla 'articulos' existe
    CONSTRAINT fk_pedido FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)  -- Asumiendo que la tabla 'pedidos' existe
);

