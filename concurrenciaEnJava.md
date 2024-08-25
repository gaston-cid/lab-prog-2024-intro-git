Mecanismos de sincronización en java

Semáforos 

Introducción

En Java, un Semáforo es un mecanismo de sincronización que se utiliza para controlar el acceso a un recurso compartido por múltiples hilos. Los semáforos mantienen un contador que representa el número de permisos disponibles para acceder al recurso. Cuando un hilo desea acceder al recurso, debe adquirir un permiso del semáforo, lo que disminuye el contador. Si el contador es mayor que cero, el hilo puede continuar y el semáforo decrece en uno. Si el contador es cero, el hilo se bloquea y espera hasta que otro hilo libere un permiso. Cuando un hilo termina de usar el recurso, debe liberar el permiso, incrementando así el contador del semáforo.

El uso de semáforos es crucial en la programación concurrente para evitar condiciones de carrera y asegurar que no más hilos del permitido accedan a un recurso crítico al mismo tiempo. En Java, el semáforo es implementado por la clase Semaphore del paquete java.util.concurrent, proporcionando métodos como acquire() para obtener un permiso y release() para liberar un permiso, asegurando un manejo de recursos seguro y eficiente en aplicaciones concurrentes.


Guía de uso

-Antes de usar semáforos, debes importar la clase Semaphore en tu programa Java: import java.util.concurrent.Semaphore;

-Para crear un semáforo, debes instanciar un objeto de la clase Semaphore indicando el número de permisos disponibles, es decir, el número de hilos que pueden acceder al recurso compartido simultáneamente. Por ejemplo: Semaphore semaforo = new Semaphore(3);
En este caso, se crea un semáforo con 3 permisos, lo que significa que hasta 3 hilos pueden acceder al recurso compartido al mismo tiempo.

-Cuando un hilo necesita acceder a un recurso controlado por el semáforo, debe intentar adquirir un permiso. Esto se hace llamando al método acquire():
try {
    semaforo.acquire();
    // Código que accede al recurso compartido.

} catch (InterruptedException e) {
    e.printStackTrace();
}

El método acquire() decrementa el contador de permisos del semáforo. Si el contador es mayor que cero, el hilo adquiere el permiso y continúa. Si es cero, el hilo se bloquea y espera hasta que un permiso sea liberado.

-Después de que el hilo ha terminado de usar el recurso compartido, debe liberar el permiso para permitir que otros hilos accedan al recurso. Esto se hace llamando al método release(): semaforo.release();
El método release() incrementa el contador de permisos del semáforo, lo que puede despertar a un hilo bloqueado que estaba esperando por un permiso.


EJEMPLO DE IMPLEMENTACION:
