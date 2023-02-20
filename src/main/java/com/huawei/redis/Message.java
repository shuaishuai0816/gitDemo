package com.huawei.redis;

import lombok.*;

import java.io.Serializable;

/**
 * @DESCRIPTION:
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_0:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message implements Serializable {
    private String title;
    private String info;
}
