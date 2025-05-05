package com._GI.Network.project.Repository;

import com._GI.Network.project.Models.Access;
import com._GI.Network.project.Models.Id_access;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface AccessRepository extends JpaRepository<Access, Id_access> {
    Access findByDateConnexion(Date date);
    @Override
    @NotNull
    Optional<Access> findById(@NotNull Id_access id);
}