package sample;









































public class MyArrayList <T> {
    private T myValue;
    int defaultCapacity=9;
    Object[] objectArray;
    Object[] tempArray;
    int currentCapacity;
    int capacity;

    public MyArrayList() {
        objectArray=new Object[defaultCapacity];
    }

    public void add(T value){
        capacity=0;
        tempArray=new Object[objectArray.length+1];
        for(int i=0;i<objectArray.length;i++){
            tempArray[i]=objectArray[i];
        }
        tempArray[tempArray.length-1]=value;
        objectArray=new Object[tempArray.length];
        for(int i=0;i<tempArray.length;i++){
            objectArray[i]=tempArray[i];
        }
        for(Object t : objectArray ){
            if(t!=null){
                currentCapacity++;
            }
        }
        tempArray=new Object[currentCapacity];
        for(int i=0;i<objectArray.length; i++){
            if(objectArray[i]!=null){
                tempArray[capacity]=objectArray[i];
                capacity++;
            }
        }
        objectArray=new Object[capacity];
        for(int i=0;i<capacity;i++){
            objectArray[i]=tempArray[i];
        }
        defaultCapacity=objectArray.length;


    }
    public void remove(int ii){
        int tempCapacity=0;
        int capacity=0;
        objectArray[ii]=null;
        for(Object t : objectArray ) {
            if (t != null) {
                tempCapacity++;
            }
        }
        tempArray=new Object[tempCapacity];
        for(int i=0;i<objectArray.length; i++){
            if(objectArray[i]!=null){
                tempArray[capacity]=objectArray[i];
                capacity++;
            }
        }
        objectArray=new Object[capacity];
        for(int i=0;i<capacity;i++){
            objectArray[i]=tempArray[i];
        }
        defaultCapacity=objectArray.length;
    }
    public boolean isEmpty(){
        if(objectArray.length==0){
            return true;
        }else{
            return false;
        }
    }
    public int length(){
        return defaultCapacity;
    }

    public T get(int i){
        return (T)objectArray[i];
    }
}
