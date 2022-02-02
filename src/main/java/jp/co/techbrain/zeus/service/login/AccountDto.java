package jp.co.techbrain.zeus.service.login;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class AccountDto {
    /**
     * ログインID
     */
    private String loginId;

    /**
     * パスワード
     */
    private String password;

    /**
     * 氏名_姓
     */
    private String nameSei;

    /**
     * 氏名_名
     */
    private String nameMei;

    /**
     * 氏名_姓(フリガナ）
     */
    private String nameSeiKana;

    /**
     * 氏名_名(フリガナ）
     */
    private String nameMeiKana;

    /**
     * ロールID (FK)
     */
    private String roleId;

    /**
     * E-mailアドレス
     */
    private String mailAddress;

    /**
     *パスワード有効期限
     */
    private LocalDateTime passwordExpirationDate;

}
