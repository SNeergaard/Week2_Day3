package com.example.week2_day3;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String biome;
    private String animal;
    private String description;

    public Animal(String biome, String animal, String description){
        this.biome = biome;
        this.animal = animal;
        this.description = description;
    }

    protected Animal(Parcel in) {
        biome = in.readString();
        animal = in.readString();
        description = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    //    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
//        @Override
//        public Animal createFromParcel(Parcel parcel) {
//            return new Animal(in);
//        }
//
//        @Override
//        public Animal[] newArray(int size) {
//            return new Animal[size];
//        }
//    };
//
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(biome);
        parcel.writeString(animal);
        parcel.writeString(description);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "biome='" + biome + '\'' +
                ", animal='" + animal + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    //    @Override
//    public int describeContents(){
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int size){
//        parcel.writeString(biome);
//        parcel.writeString(animal);
//
//
//
//
//    }
}
