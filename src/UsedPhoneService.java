package com.minjeong.usedPhone.service;

import com.minjeong.usedPhone.dto.ResponseWrapper;
import com.minjeong.usedPhone.dto.UsedPhoneDTO;
import com.minjeong.usedPhone.dto.UsedPhoneRequestDTO;
import com.minjeong.usedPhone.dto.UsedPhoneResponseDTO;
import com.minjeong.usedPhone.entity.UsedPhoneEntity;
import com.minjeong.usedPhone.repository.UsedPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsedPhoneService {

    private final UsedPhoneRepository repository;

    public ResponseWrapper<UsedPhoneResponseDTO> save(UsedPhoneRequestDTO requestDTO) {
        UsedPhoneEntity entity = requestDtoToEntity(requestDTO);
        UsedPhoneEntity saved = repository.save(entity);
        UsedPhoneResponseDTO responseDTO = entityToResponseDto(saved);
        return ResponseWrapper.success(responseDTO, "중고폰이 성공적으로 등록되었습니다.", "PHONE_CREATE_SUCCESS");
    }
//테스트
    public ResponseWrapper<UsedPhoneResponseDTO> update(Long id, UsedPhoneRequestDTO requestDTO) {
        UsedPhoneEntity entity = requestDtoToEntity(requestDTO);
        entity.setId(id);
        UsedPhoneEntity saved = repository.save(entity);
        UsedPhoneResponseDTO responseDTO = entityToResponseDto(saved);
        return ResponseWrapper.success(responseDTO, "중고폰 정보가 성공적으로 수정되었습니다.", "PHONE_UPDATE_SUCCESS");
    }

    public List<UsedPhoneResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::entityToResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<UsedPhoneResponseDTO> findById(Long id) {
        return repository.findById(id).map(this::entityToResponseDto);
    }

    public ResponseWrapper<Object> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseWrapper.success("중고폰이 성공적으로 삭제되었습니다.", "PHONE_DELETE_SUCCESS");
    }

    private UsedPhoneResponseDTO entityToResponseDto(UsedPhoneEntity entity) {
        return new UsedPhoneResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getSeller(),
                entity.getPrice(),
                entity.getImageUrl(),
                entity.getNumber()
        );
    }

    private UsedPhoneEntity requestDtoToEntity(UsedPhoneRequestDTO requestDTO) {
        UsedPhoneEntity entity = new UsedPhoneEntity();
        entity.setName(requestDTO.getName());
        entity.setSeller(requestDTO.getSeller());
        entity.setPrice(requestDTO.getPrice());
        entity.setImageUrl(requestDTO.getImageUrl());
        entity.setNumber(requestDTO.getNumber());
        return entity;
    }
}
