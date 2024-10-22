
#ifndef REGRESION_LINEAL_H
#define REGRESION_LINEAL_H

#include "imprimir.h" 
#include "leer_csv.h"
#include <iostream>
#include <cmath>
#include <iomanip>  // Para formatear la salida

using namespace std;

void regresion(todo* arr, int n) {
    // Crear arreglos dinámicos para almacenar las habitaciones y precios
    float* habi = new float[n];
    float* preci = new float[n];

    for (int r = 0; r < n; r++) {
        habi[r] = arr[r].habitaciones;
        preci[r] = arr[r].precio;
    }

    // Normalizar los datos (entre 0 y 1)
    float max_habi = habi[0], max_preci = preci[0];
    float min_habi = habi[0], min_preci = preci[0];

    for (int i = 1; i < n; ++i) {
        if (habi[i] > max_habi) max_habi = habi[i];
        if (preci[i] > max_preci) max_preci = preci[i];
        if (habi[i] < min_habi) min_habi = habi[i];
        if (preci[i] < min_preci) min_preci = preci[i];
    }

    for (int i = 0; i < n; ++i) {
        habi[i] = (habi[i] - min_habi) / (max_habi - min_habi); // Normalización
        preci[i] = (preci[i] - min_preci) / (max_preci - min_preci);
    }

    // Parámetros iniciales de la regresión
    float m = 0.0; // Pendiente
    float b = 0.0; // Intercepto
    float alpha = 0.001; // Tasa de aprendizaje ajustada
    float mse = 0.0; // Error cuadrático medio
    float mse_objetivo = 0.001; // Umbral para detener el descenso de gradiente
    int max_iteraciones = 20000; // Límite máximo de épocas
    int iteraciones = 0;

    // Descenso de gradiente con criterio de convergencia basado en MSE
    do {
        float gradiente_m = 0.0;
        float gradiente_b = 0.0;
        mse = 0.0;

        for (int i = 0; i < n; ++i) {
            float prediccion = m * habi[i] + b;
            float error = preci[i] - prediccion;
            mse += error * error; // Sumar el cuadrado de los errores
            gradiente_m += -2 * habi[i] * error;
            gradiente_b += -2 * error;
        }

        // Calcular el MSE promedio
        mse /= n;

        // Actualizar los parámetros m y b
        m -= (gradiente_m / n) * alpha;
        b -= (gradiente_b / n) * alpha;

        iteraciones++;

    } while (mse > mse_objetivo && iteraciones < max_iteraciones);

    // Desnormalizar los parámetros m y b
    m = m * (max_preci - min_preci) / (max_habi - min_habi);
    b = b * (max_preci - min_preci) + min_preci - m * min_habi;

    // Imprimir resultados de la regresión en formato de tabla
    cout << "Desea ver los resultados de la regresión lineal como: " << endl;
    cout << "#epocas, ecuación recta, error cuadrático?" << endl;
    cout << "si o no: ";
    string respuesta2;
    cin >> respuesta2;

    if (respuesta2 == "si" || respuesta2 == "SI" || respuesta2 == "Si") {
        imprimirTablaRegresion(iteraciones, m, b, mse);
    }

    // Preguntar al usuario cuántas predicciones quiere hacer
    int num_predicciones;
    cout << "¿Cuántas predicciones de precio deseas realizar?: ";
    cin >> num_predicciones;

    // Arreglos para almacenar habitaciones y predicciones
    float* habitaciones_pred = new float[num_predicciones];
    float* precios_pred = new float[num_predicciones];

    // Hacer las predicciones para el número de habitaciones ingresado
    for (int i = 0; i < num_predicciones; ++i) {
        cout << "Ingrese el número de habitaciones para la predicción " << i + 1 << ": ";
        cin >> habitaciones_pred[i];

        // Predecir precio y desnormalizar el resultado
        precios_pred[i] = m * habitaciones_pred[i] + b;
    }

    // Imprimir las predicciones en formato de tabla
    imprimirTablaPredicciones(num_predicciones, habitaciones_pred, precios_pred);

    // Liberar la memoria de los arreglos dinámicos
    delete[] habi;
    delete[] preci;
    delete[] habitaciones_pred;
    delete[] precios_pred;
}

#endif // REGRESION_LINEAL_H