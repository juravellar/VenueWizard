CREATE TABLE `place` (
    `id` bigint(20) NOT NULL,
    `nome` varchar(255) NOT NULL,
    `slug` varchar(255) NOT NULL,
    `city` varchar(255) NOT NULL,
    `state` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL.
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
--
-- Indexes for table
--
ALTER TABLE `place`
ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT for table
--
ALTER TABLE `place`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--