# Servicio 2: Reconocimientos Extra

Dentro del contexto de [Sistema para la Mejora del Acceso Alimentario en Contextos de Vulnerabilidad Socioeconómica
](https://docs.google.com/document/d/13niiEppxrm8LjyrxmH5Pskrc7VVuPKWSFRi3WvhsXns)

Hay empresas que decidieron brindar beneficios a los colaboradores pero desde sus propias plataformas.
Para eso vamos a implementar un servicio que recomiende colaboradores de acuerdo a los parámetros
solicitados por las distintas empresas.

La empresa solicitará una cantidad mínima de puntos requeridos, una cantidad mínima de donación de
viandas realizada en el último mes y una cantidad máxima de colaboradores a ser incorporados en la
plataforma externa. En caso de que no se llegue a la cantidad de colaboradores solicitados, se deberán
devolver únicamente los que cumplan las condiciones.

Nuestro sistema debe devolver una lista de colaboradores a ser reconocidos por otras empresas, junto con
el puntaje que obtuvo cada uno hasta el momento.

## Definición de la API

Nuestra API ofrecerá un endpoint que permitirá a las empresas solicitar colaboradores a reconocer.
Contara con los siguientes query params:
- `minPoints`: cantidad mínima de puntos requeridos
- `minDonations`: cantidad mínima de donación de viandas realizada en el último mes
- `limit`: cantidad máxima de colaboradores a ser devueltos a la plataforma externa
