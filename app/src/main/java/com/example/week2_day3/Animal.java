package com.example.week2_day3;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String biome;
    private String animal;
    private String description;
    private int sound;


    public Animal(String biome, String animal, String description, Integer sound){
        this.biome = biome;
        this.animal = animal;
        this.description = description;
        this.sound = sound;
    }

    protected Animal(Parcel in) {
        biome = in.readString();
        animal = in.readString();
        description = in.readString();
        sound = in.readInt();
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


    public void setSound(int sound) { this.sound = sound; }

    public int  getSound() { return sound; }

    public String getAnimal() { return animal; }

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
        parcel.writeInt(sound);
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
