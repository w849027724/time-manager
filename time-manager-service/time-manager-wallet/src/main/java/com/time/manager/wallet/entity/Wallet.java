package com.time.manager.wallet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.time.manage.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wlj
 * @Title: WalletService
 * @date 2020-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Wallet对象", description = "")
public class Wallet extends BaseEntity<Wallet> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "wallet_id", type = IdType.AUTO)
    private Integer walletId;

    private Integer walletNum;


}
