package ync.pyb.entity;

import lombok.*;
import org.hibernate.loader.collection.OneToManyJoinWalker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Detail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private Long detailId;

	@Column(columnDefinition = "TEXT", nullable = false)
    private String detailIncluded;

	@Column(columnDefinition = "TEXT", nullable = false)
    private String detailNotIncluded;
	
	@Column(columnDefinition = "TEXT", nullable = false)
    private String detailNotice;

}
