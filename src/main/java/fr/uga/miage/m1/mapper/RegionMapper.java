package fr.uga.miage.m1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.RegionDTO;
import fr.uga.miage.m1.model.Region;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    
    Region dtoToEntity(RegionDTO regionDTO);

    RegionDTO entityToDTO(Region region);

    List<Region> dtoToEntity(List<RegionDTO> regionDTOs);

    List<RegionDTO> entityToDTO(List<Region> regions);
}
