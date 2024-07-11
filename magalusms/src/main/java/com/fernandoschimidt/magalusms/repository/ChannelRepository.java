package com.fernandoschimidt.magalusms.repository;

import com.fernandoschimidt.magalusms.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
