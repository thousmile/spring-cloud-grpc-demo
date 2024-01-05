package com.xaaef.grpc.client;

import com.xaaef.grpc.lib.pb.TokenInfo;
import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author WangChenChen
 * @version 1.0.0
 * @date 2024/1/5 18:12
 */


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    private Long id;

    private String name;

    private TokenInfo token;

}
