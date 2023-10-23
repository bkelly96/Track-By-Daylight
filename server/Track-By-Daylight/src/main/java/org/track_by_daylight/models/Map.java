package org.track_by_daylight.models;

import java.util.Objects;

public class Map {

    public int mapId;

    public String mapName;

    public String realmName;

    public Map() {
    }

    public Map(int mapId, String mapName, String realmName) {
        this.mapId = mapId;
        this.mapName = mapName;
        this.realmName = realmName;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return mapId == map.mapId && Objects.equals(mapName, map.mapName) && Objects.equals(realmName, map.realmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapId, mapName, realmName);
    }
}
