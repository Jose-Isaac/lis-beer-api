package com.lisbeer.domain.stores

import com.lisbeer.application.rules.Access
import com.lisbeer.domain.address.Address
import com.lisbeer.domain.beers.Beer
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(
    name = "stores",
    indexes = [Index(name = "stores_pid_index", columnList = "publicId", unique = true)]
)
class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(unique = true, nullable = false)
    val publicId: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val name: String,

    @Enumerated(EnumType.ORDINAL)
    val accessRule: Access = Access.STORE,

    @Email
    @Column(unique = true, nullable = false)
    val email: String,

    @Column(unique = true, nullable = false)
    val password: String,

    @Column(nullable = false)
    val evaluation: Double = 0.0,

    @Column(unique = true, nullable = false)
    val photoUrl: String,

    @OneToMany(mappedBy = "store")
    val beers: List<Beer>,

    @OneToOne
    val address: Address
)
