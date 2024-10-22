#ifndef VALIDACION_H
#define VALIDACION_H

#include <iostream>
#include <cmath>
#include "regrecion_lineal.h" 

using namespace std;

void dividirDataset(todo* arr, int n, float porcentaje_entrenamiento, todo*& entrenamiento, todo*& prueba, int& tam_entrenamiento, int& tam_prueba) 
{
    tam_entrenamiento = static_cast<int>(n * porcentaje_entrenamiento);
    tam_prueba = n - tam_entrenamiento;

    entrenamiento = new todo[tam_entrenamiento];
    prueba = new todo[tam_prueba];

    for (int i = 0; i < tam_entrenamiento; ++i) {
        entrenamiento[i] = arr[i];
    }

    for (int i = 0; i < tam_prueba; ++i) {
        prueba[i] = arr[tam_entrenamiento + i];
    }
}

void probarModelo(todo* prueba, int tam_prueba) {
    cout << "Probando el modelo con los datos de prueba..." << endl;

    // Aquí se realiza la regresión con los datos de prueba
    regresion(prueba, tam_prueba);

    cout << "Prueba completada." << endl;
}

#endif // VALIDACION_H

