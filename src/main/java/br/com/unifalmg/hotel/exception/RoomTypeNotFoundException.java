package br.com.unifalmg.hotel.exception;

public class RoomTypeNotFoundException extends RuntimeException{
    public RoomTypeNotFoundException(String message){ super(message); }
}
