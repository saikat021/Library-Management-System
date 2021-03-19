package com.StudentLibrary.Studentlibrary.Repositories;

import com.StudentLibrary.Studentlibrary.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CardRepository extends JpaRepository<Card,Integer> {

    @Modifying
    @Query(value = "update card c set c.card_status=:new_card_status where c.id in(select card_id from student s where s.id=:student_id)",nativeQuery = true)
    void deactivateCard(@Param("student_id") int student_id,@Param("new_card_status") String new_card_status);

//    @Modifying
//    @Query("update Card c set c.books=:#{#new_card.books} where c.id=:#{#new_card.id}")
//    int updateCard(@Param("new_card") Card card);
}
