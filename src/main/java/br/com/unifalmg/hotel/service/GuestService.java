package br.com.unifalmg.hotel.service;

import br.com.unifalmg.hotel.entity.Guest;
import br.com.unifalmg.hotel.exception.GuestNotFoundException;
import br.com.unifalmg.hotel.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository repository;

    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    public Guest findById(Integer id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("Null ID when fetching for a guest.");
        }
        return repository.findById(id).orElseThrow(
                () -> new GuestNotFoundException(String.format("No guest found for id %d", id))
        );
    }

    public void saveGuest(Guest guest) {
        repository.save(guest);
    }

    public void deleteGuest(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteRoomByGuestId(id);
            repository.deleteReservationByGuestId(id);
            repository.deleteByGuestId(id);
        }
        throw new GuestNotFoundException(String.format("User with id[%d] not found!!", id));
    }

    public List<Guest> findByFilter(String name, String last_name, String cpf, Character gender){
        return repository.findByFilter(name, last_name, cpf, gender);
    }

    public List<Guest> orderGuestsAtoZ() {
        return repository.orderGuestsAtoZ();
    }

    public List<Guest> orderGuestsZtoA() {
        return repository.orderGuestsZtoA();
    }

    public List<Object[]> guestAndReservation(Integer id){
        return repository.selectGuestAndYoursReservationsByGuestId(id);
    }
}
