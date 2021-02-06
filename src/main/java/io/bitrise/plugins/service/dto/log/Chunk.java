package io.bitrise.plugins.service.dto.log;

public class Chunk {
    private String chunk;
    private int position;

    public Chunk() {
    }

    public Chunk(String chunk, int position) {
        this.chunk = chunk;
        this.position = position;
    }

    public String getChunk() {
        return chunk;
    }

    public void setChunk(String chunk) {
        this.chunk = chunk;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Chunk{" +
                "chunk='" + chunk + '\'' +
                ", position=" + position +
                '}';
    }
}
