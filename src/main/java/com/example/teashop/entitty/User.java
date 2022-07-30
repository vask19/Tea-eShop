package com.example.teashop.entitty;


import com.example.teashop.entitty.role.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ConstructorBinding
//@Builder
//@Entity
//@Table(name = "users")
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column
//    private String username;
//    @Column
//    private String password;
//    private boolean isActive = true;
//    @Transient
//    private Collection<? extends GrantedAuthority> authorities;
//    private ERole role;
//
//
//
//    @ElementCollection(targetClass = ERole.class)
//    @CollectionTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"))
//    private Set<ERole> roles = new HashSet<>();
//
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private Bucket bucket;
//
//    public User(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//
//    @Override
//    public String getPassword(){
//        return password;
//    }
//    @Override
//    public String getUsername(){
//       return username;
//    }
//
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive;
//    }
//}


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConstructorBinding
@Builder
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Bucket bucket;

    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    private Set<ERole> roles = new HashSet<>();

    @Column
    private String role;




    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

