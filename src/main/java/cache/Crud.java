package cache;

public interface Crud<E> {

    E create(E element);
    E read(String id);
    E update(String id, E element);
    E delete(String id);
}
