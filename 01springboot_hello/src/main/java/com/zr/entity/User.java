package com.zr.entity;

import lombok.*;

/**
 * @Getter and @Setter
 * @FieldNameConstants
 * @ToString
 * @EqualsAndHashCode
 * @AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
 * @Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
 * @Data
 * @Builder
 * @SuperBuilder
 * @Singular
 * @Delegate
 * @Value
 * @Accessors
 * @Wither
 * @With
 * @SneakyThrows
 * @val
 * @var
 * experimental @var
 * @UtilityClass
 * Lombok config system
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private int age;
}
