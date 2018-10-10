# TPOSupermercado
TPOSupermercado de Programacion Concurrente

# Consigna
Se desea simular una salida de compras al supermercado VaRaTiJa.
El Supermercado ofrece a sus clientes un conjunto de productos. Con el fin de atraer
clientes selecciona algunos productos para oferta. El conjunto de productos en oferta
se modifica, agregando y eliminando productos cuando:

- Un producto haya estado en oferta por más de una semana.

- Se ha llegado al stock mínimo del producto.

- Al Gerente de Ventas le parece adecuado cambiar un producto por otro.

El cliente puede comprar productos que estén en oferta o que no.

En las horas picos normalmente hay N cajas atendiendo en paralelo. Cuando un
producto pasa por la caja el sistema verifica si el mismo es uno de los productos en
oferta. De ser así, aplica un 10% de descuento.

Diariamente llegan al supermercado diferentes distribuidores trayendo pedidos de
productos.

Considere que en todo momento debe mantenerse actualizado el stock de los productos.
Resolver maximizando la concurrencia entre cajas, evitando bloqueos e inconsistencia.

## Cosas por hacer
- [ ] Repositor viene y deja productos.
- [ ] Paso del tiempo en el supermercado.
- [ ] Aplicar descuento a los productos en oferta cuando pasan por caja.
- [ ] Cambiar los productos de oferta cuando se dan las condiciones.
