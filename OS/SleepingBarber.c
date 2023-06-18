/**
 * @file SleepingBarber.c
 * @author Section A
 * 1. Adane Moges           ETS0079/13
 * 2. Abenezer Merdekiyos   ETS 0056/13
 * 3. Abdulmajid Awol       ETS0016/13
 * 4. Aduna Kebeda          ETS0088/13
 * @brief Implementation of Sleeping Barber problem in C
 * @version 0.1
 * @date 2023-06-05
 *
 * @copyright Copyright (c) 2023
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define NUM_CHAIRS 5

sem_t barber_ready;
sem_t customer_ready;
pthread_mutex_t waiting_room_mutex;
int waiting_customers = 0;
/**
 * barber - Function to waits for a customer to arrive by calling
 *
 * @param arg
 * @return void*
 */
void *barber(void *arg)
{
    for (;;)
    {
        sem_wait(&customer_ready);                 // Wait for a customer
        pthread_mutex_lock(&waiting_room_mutex);   // Lock the waiting room
        waiting_customers--;                       // Remove a customer from the waiting room
        sem_post(&barber_ready);                   // Signal that the barber is ready
        pthread_mutex_unlock(&waiting_room_mutex); // Unlock the waiting room
        printf("Barber is cutting hair.\n");
        sleep(1); // Simulate time taken for a haircut
    }
    return NULL;
}
/**
 * customer - Function to simulates a customer arriving at the barber shop
 *
 * @brief simulates a customer arriving at the barber shop
 *
 * @param arg
 * @return void*
 */
void *customer(void *arg)
{
    pthread_mutex_lock(&waiting_room_mutex); // Lock the waiting room
    if (waiting_customers < NUM_CHAIRS)
    {
        waiting_customers++; // Add a customer to the waiting room
        printf("Customer arrived. %d customers waiting.\n", waiting_customers);
        sem_post(&customer_ready);                 // Signal that a customer is ready
        pthread_mutex_unlock(&waiting_room_mutex); // Unlock the waiting room
        sem_wait(&barber_ready);                   // Wait for the barber to be ready
        printf("Customer is getting a haircut.\n");
    }
    else
    {
        pthread_mutex_unlock(&waiting_room_mutex); // Unlock the waiting room
        printf("Customer left (no available chairs).\n");
    }
    return NULL;
}
/**
 * @brief main function the execution starts here
 *
 * @return int
 */
int main()
{
    pthread_t barber_thread;
    pthread_t customer_threads[NUM_CHAIRS + 1];

    sem_init(&barber_ready, 0, 0);
    sem_init(&customer_ready, 0, 0);
    pthread_mutex_init(&waiting_room_mutex, NULL);

    pthread_create(&barber_thread, NULL, barber, NULL);

    for (int i = 0; i <= NUM_CHAIRS; i++)
    {
        pthread_create(&customer_threads[i], NULL, customer, NULL);
        sleep(2); // Simulate time between customer arrivals
    }

    for (int i = 0; i <= NUM_CHAIRS; i++)
    {
        pthread_join(customer_threads[i], NULL);
    }

    sem_destroy(&barber_ready);
    sem_destroy(&customer_ready);
    pthread_mutex_destroy(&waiting_room_mutex);

    return 0;
}
