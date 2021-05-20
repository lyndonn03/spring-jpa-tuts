package io.lpamintuan.backend.backend.library;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Relation(itemRelation = "library", collectionRelation = "libraries")
@Data
@EqualsAndHashCode(callSuper = false)
@Getter
@NoArgsConstructor
public class LibraryRepresentation extends RepresentationModel<LibraryRepresentation> {

    private UUID id;
    private String name;

    
}
