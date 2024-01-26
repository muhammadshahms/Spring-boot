package com.example.demo.services;

import com.example.demo.dto.ClubDto;
import com.example.demo.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(Club club);

    ClubDto findClubById(long clubId);


    void updateClub(ClubDto club);

    void deleteClub(Long clubId);
}
