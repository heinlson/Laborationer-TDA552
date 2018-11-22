import java.util.ArrayList;
import java.util.List;

class CarContainer<T extends Car> {

    private int maxSize;
    private final List<T> cars = new ArrayList<>();



    CarContainer(int maxSize){
        this.maxSize = maxSize;
    }

    int size(){
        return cars.size();
    }


    int getMaxSize() {
        return maxSize;
    }


    List<T> getCars() {
        return cars;
    }


    void add(T c, Object current){
        if(cars.size() < maxSize && c != current){
            cars.add(c);
        }
    }

    T remove(int internalIndex){
        return cars.remove(internalIndex);
    }
}
