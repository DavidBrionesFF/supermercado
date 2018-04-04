use cursosql;

#---------CATEGORIA---------#

#Crear
create procedure sp_crearCategoria(
	_nombre varchar(255),
	_descripcion varchar(500)
)
	insert into cursosql.categoria (nombre, descripcion) 
	values (_nombre, _descripcion);

#Obtener
create procedure sp_obtenerCategorias()
	select * from categoria order by nombre desc;

#Eliminar
create procedure sp_eliminarCategoria(_id_categoria int)
	delete from categoria where id_categoria=_id_categoria;

#Actualizar
create procedure sp_actualizarCategoria(
	_id_categoria int,
	_nombre varchar(255),
	_descripcion varchar(500)
)
	update categoria set nombre=_nombre, descripcion=_descripcion where 
	id_categoria=_id_categoria;

#Obtener por identificador
create procedure sp_obtenerByIdentificador(_id_categoria int)
	select * from categoria where id_categoria=_id_categoria;

#---------MARCA---------#

#Crear
create procedure sp_crearMarca(
	_nombre varchar(255),
	_descripcion varchar(300)
)
	insert into marca (nombre, descripcion, fecha_integracion) 
	values(_nombre, _descripcion, now());

#Actualizar
create procedure sp_ActualizarMarca(
	_id_marca int,
	_nombre varchar(255),
	_descripcion varchar(300)
)
	update marca set nombre=_nombre, descripcion=_descripcion where
	id_marca=_id_marca;

#Eliminar
create procedure sp_eliminarMarca(_id_marca int)
	delete from marca where id_marca=_id_marca;

#Obtener
create procedure sp_obtenerMarca()
	select * from marca order by nombre desc;


#Obtener marca por producto
create procedure sp_obtenerMarcaByProducto(_id_producto int)
	select m.* from producto p inner join marca m on p.id_marca=m.id_marca 
	where p.id_producto=_id_producto;

#Buscar marca
create procedure sp_buscarMarca(_nombre varchar(255), pagina int)
	select * from marca where nombre like _nombre limit 10;

#Obtener ranking marcas mas vendidas
create procedure sp_obtenerMarcasConMasProductos()
	select 
		m.*, count(p.nombre) as cantidad_productos 
	from 
		marca m left join producto p on m.id_marca=p.id_marca 
	group by 
		m.nombre 
	order by 
		cantidad_productos desc;

#---------PRODUCTO---------#

#CREAR
create procedure sp_crearProducto(
	_nombre varchar(255),
	_precio decimal,
	_descripcion varchar(300),
	_poster varchar(500),
	_categoria int,
	_marca int,
	_usuario int,
	_codigo_producto varchar(60)
)
	insert into producto 
	(
		nombre, descripcion, 
		poster, precio, id_categoria, 
		id_marca, usuario_ingreso,
		codigo_producto, fecha_ingreso
	) 

	values
	(
		_nombre, _descripcion, _poster, abs(_precio),
		_categoria, _marca, _usuario, _codigo_producto,
		now()
	);

call sp_crearProducto("Computadora",10000, "Computadora de sobremesa","default",3,3,1,"A005");

#Actualizar
create procedure sp_actualizarProducto(
	_id_producto int,
	_nombre varchar(255),
	_precio decimal,
	_descripcion varchar(300),
	_poster varchar(500),
	_categoria int,
	_marca int,
	_usuario int,
	_codigo_producto varchar(60)
)
	update 
		producto 
	set 
		nombre=_nombre,
		precio=_precio,
		descripcion=_descripcion,
		poster=_poster,
		id_categoria=_categoria,
		id_marca=_marca,
		usuario_ingreso=_usuario,
		codigo_producto=_codigo_producto,
		fecha_ingreso=now()
		
	where	
		id_producto=_id_producto;

call sp_actualizarProducto
(1,"Tablet",7000, "Tableta wifi","default",3,4,1,"A001");

#Eliminar
create procedure sp_eliminarProducto(_id_producto int)
	delete from producto where id_producto=_id_producto;

call sp_eliminarProducto(5);

#Obtener todos
delimiter __
create procedure sp_obtenerProductos(config varchar(6), pagina int, tamano int)
begin

	if config="nombre" then 

		select * from producto 
			order by nombre asc limit tamano offset pagina;

	elseif config="precio" then

		select * from producto
		order by precio desc limit tamano offset pagina;

	elseif config="*" then

		select * from producto 
		order by precio asc, precio desc limit tamano offset pagina;

	else 
		select * from producto
		order by codigo_producto limit tamano offset pagina;
	end if;
end __

#Obtener producto por id
delimiter __
create procedure sp_obtenerProducto(_id_producto int)
begin
	select * from producto where id_producto=_id_producto;
end __

#Obtener productos de una marca especifica
delimiter __
create procedure sp_obtenerProductosByMarca(_marca varchar(255))
begin 
	select
		p.* 
	from 	
		marca m inner join producto p 
	on 
		m.id_marca=p.id_marca 
	where 
		m.nombre=_marca 
	order by 
		p.codigo_producto;
end __

#Obtener productos de una categoria
delimiter __
create procedure sp_obtenerProductoByCategoria(_categoria varchar(255))
begin 
	select 
		p.* 
	from 
		categoria c inner join producto p 
	on 
		c.id_categoria=p.id_categoria 
	where 
		c.nombre=_categoria 
	order by 
		p.codigo_producto;
end __

#---------USUARIO---------#
#Crear 
delimiter __
create procedure sp_crearUsuario(
	_nombre varchar(255),
	_apellido varchar(255),
	_contrasena varchar(255),
	_fecha_nacimiento date ,
	_nombre_usuario varchar(255),
	_perfil varchar(255),
	_rol int
)
begin 
	insert into 
		usuario (nombre,apellido,contrasena,fecha_nacimiento,nombre_usuario,perfil,rol)
		values(_nombre,_apellido,_contrasena,_fecha_nacimiento,_nombre_usuario,_perfil,_rol);
end __

#Actualizar
delimiter __
create procedure sp_actualizarUsuario(
	_id_usuario int,
	_nombre varchar(255),
	_apellido varchar(255),
	_contrasena varchar(255),
	_fecha_nacimiento date ,
	_nombre_usuario varchar(255),
	_perfil varchar(255),
	_rol int
)
begin 
	update usuario set
		nombre=_nombre,
		apellido=_apellido,
		contrasena=_contrasena,
		fecha_nacimiento=_fecha_nacimiento,
		nombre_usuario=_nombre_usuario,
		perfil=_perfil,
		rol=_rol
	where id_usuario = _id_usuario;
end __

#Eliminar
create procedure sp_eliminar(_id int)
	delete from usuario where id_usuario=id;

#Obtener 
create procedure sp_obtenerTodos(pagina int, tamano int)
    select * from usuario order by nombre limit tamano offset pagina;



#---------INGRESOS---------#
#ingresar
delimiter __
create procedure sp_ingresar(
	_id_usuario int 
)
begin
	insert into ingresados (usuario_id, tipo, fecha_ingreso) 
	values(_id_usuario, true, now());

	update usuario set activo=true where id_usuario=_id_usuario;
end __

call sp_ingresar(1);
#Egresar
delimiter __
create procedure sp_egresar(
	_id_usuario int 
)
begin
	insert into ingresados (usuario_id, tipo, fecha_ingreso) 
	values(_id_usuario, false, now());

	update usuario set activo=false where id_usuario=_id_usuario;
end __

call sp_egresar(1);
#---------FACTURA---------#
delimiter __
create procedure sp_crearFactura(
	_subtotal decimal,
	_total decimal,
	_usuario int,
	_descripcion varchar(500)
)
begin
	insert into factura 
		(fecha_facturacion, descripcion,usuario_id_facturacion,subtotal, total)
	values
		(now(), _descripcion,_usuario, _subtotal,_total);
end __

#action
delimiter __
create procedure sp_actualizarFactura(
	_id_factura int,
	_subtotal decimal,
	_total decimal,
	_descripcion varchar(500)
)
begin
	update factura set
		fecha_facturacion=now(),
		descripcion=_descripcion,
		subtotal=_subtotal, 
		total=_total
	where 
		id_factura=_id_factura;
end __

call sp_actualizarFactura(1,34,56,"Nada");

#---------DESCRIPCION---------#
#Crear
delimiter __
create procedure sp_crearDescripcion(
	_cantidad int,
	_factura int ,
	_producto int
)
begin
	insert into 
		descripcion (cantidad,precio,factura_id_factura, producto_id_producto)
	values(
		_cantidad,
		(select precio from producto where id_producto=_producto)
		,_factura,_producto
	);
end __


#Actualizar
delimiter __
create procedure sp_actualizarDescripcion(
	_id_desripcion int,
	_cantidad int,
	_producto int
)
begin 
	update 
		descripcion
	set
		cantidad =_cantidad,
		producto_id_producto=_producto,
		precio=(select precio from producto where id_producto=_producto)
	where
		id_descripcion=_id_desripcion;
end __

#Eliminar
delimiter __
create procedure sp_eliminarDescripcion(_id_descripcion int)
begin
	delete from descripcion where id_descripcion=_id_descripcion;
end __

delimiter __
#Obtener por factura
create procedure sp_obtenerDescripcionFactura(_id_factura int)
begin
	select d.* from factura f inner join descripcion d on 
	f.id_factura=d.factura_id_factura 
	where id_factura=_id_factura;
end __

select * from usuario;



