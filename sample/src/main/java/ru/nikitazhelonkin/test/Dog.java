package ru.nikitazhelonkin.test;

import java.util.Arrays;

import ru.nikitazhelonkin.sqlite.annotation.Index;
import ru.nikitazhelonkin.sqlite.annotation.SQLiteColumn;
import ru.nikitazhelonkin.sqlite.annotation.SQLiteObject;

/**
 * Created by nikita on 29.03.17.
 */


@SQLiteObject(value = "dog_table",
        deserialization = SQLiteObject.Deserialization.CONSTRUCTOR,
        indices = @Index(name = "dog_table_unique_index", value = {"name", "age"}, unique = true))
public class Dog {

    @SQLiteColumn(primaryKey = true, autoincrement = true)
    private long mId;

    @SQLiteColumn(notnull = true)
    private String mName;

    @SQLiteColumn
    private int mAge;

    @SQLiteColumn
    private String[] mArray;

    @SQLiteColumn(references = "dog_owner_table(id) ON DELETE CASCADE")
    private long mDogOwnerId;

    public Dog(){

    }

    public Dog(long id, String name, int age, String[] array, long dogOwnerId) {
        mId = id;
        mName = name;
        mAge = age;
        mArray = array;
        mDogOwnerId = dogOwnerId;
    }

    public Dog(String name, int age, long dogOwnerId) {
        mName = name;
        mAge = age;
        mDogOwnerId = dogOwnerId;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public void setArray(String[] array) {
        mArray = array;
    }

    public String[] getArray() {
        return mArray;
    }

    public void setDogOwnerId(long dogOwnerId) {
        mDogOwnerId = dogOwnerId;
    }

    public long getDogOwnerId() {
        return mDogOwnerId;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mAge=" + mAge +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Dog dog = (Dog) object;

        if (mId != dog.mId) return false;
        if (mAge != dog.mAge) return false;
        if (mDogOwnerId != dog.mDogOwnerId) return false;
        if (mName != null ? !mName.equals(dog.mName) : dog.mName != null) return false;
        return Arrays.equals(mArray, dog.mArray);

    }

}
