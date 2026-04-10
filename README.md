# 🐾 RefugioAnimales - Sistema de Gestión en Consola

## 📌 Descripción del proyecto

Este proyecto consiste en un sistema en consola desarrollado en Java para la gestión de un refugio de animales.

Permite registrar animales, administrar especies, gestionar adopciones y generar reportes básicos. Está diseñado para ser simple, claro y funcional, pensado para el uso diario por voluntarios.

---

## 🧱 Estructuras de datos utilizadas

El sistema utiliza distintas estructuras para organizar la información:

- **List<String> animales**
  - Almacena los nombres de todos los animales registrados.

- **Map<String, String> estadoAnimal**
  - Relaciona cada animal con su estado:
    - "Disponible"
    - "Adoptado"

- **Set<String> especies**
  - Guarda las especies registradas sin duplicados.

- **Map<String, String> animalEspecie**
  - Relaciona cada animal con su especie.

- **Array (String[]) estados**
  - Contiene los estados posibles del sistema:
    - Disponible
    - Adoptado

---

## ▶️ Cómo ejecutar el programa

1. Asegúrate de tener Java instalado (Java 21 recomendado).
2. Guarda el archivo como:
  RefugioAnimales.java
  
3. Compila el programa:
  javac RefugioAnimales.java
  
4. Ejecuta el programa:

---

## 🧭 Ejemplo de menú
    === REFUGIO DE ANIMALES ===
    1.Registrar animal
    2.Registrar especie
    3.Marcar animal como adoptado
    4.Mostrar animales disponibles
    5.Mostrar animales adoptados
    6.Mostrar reporte general
    7.Salir

    
---

## ⚠️ Validaciones implementadas

- No se permiten animales duplicados
- No se pueden registrar animales sin una especie válida
- No se pueden adoptar animales inexistentes
- Manejo de errores en entradas numéricas
- Mensajes claros para el usuario

---

## 📊 Funcionalidades principales

- Registro de especies
- Registro de animales
- Gestión de adopciones
- Visualización de animales disponibles y adoptados
- Reporte general con formato tipo tabla

---

## 👥 Integrantes del equipo

- Kevin Lizama  (Dueño del repositor)
- Brandon Inastroza  (Menu y opción 5)
- Matías Celis  (Opción 1)
- Camila Valdebenito (opción 2)
- Natasha Cruz  (Opción 3 y 4)
- Valentina Llanten  (Opción 6)

---

## 🎓 Enfoque del proyecto

Este sistema fue desarrollado con un enfoque educativo para fortalecer:

- Uso correcto de estructuras de datos
- Lógica de programación
- Validaciones reales
- Organización del código
- Preparación para Programación Orientada a Objetos (POO)

---

## 💬 Mensaje final

> “No es importante que el código sea perfecto.
>
> Es importante que **funcione, sea claro y tenga sentido**.”
