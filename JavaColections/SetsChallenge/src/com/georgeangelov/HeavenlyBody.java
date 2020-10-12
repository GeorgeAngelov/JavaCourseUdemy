package com.georgeangelov;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;

    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes{
        STAR,
        PLANET,
        MOON,
        ASTEROID,
        COMET,
        DWARF_PLANET
    }
    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name,BodyTypes bodyType){
        return new Key(name,bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyTypes + ", " + this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyType){
            this.bodyTypes = bodyType;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyTypes.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())){
                return (this.bodyTypes == key.getBodyTypes());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyTypes;
        }
    }
}
