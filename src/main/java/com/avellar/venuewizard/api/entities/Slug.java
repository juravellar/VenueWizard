package com.avellar.venuewizard.api.entities;

public class Slug {
    public static String getSlug(String input) {
        // Aqui você implementa a lógica para transformar a string 'input' em um slug
        // Por exemplo, removendo espaços, convertendo para minúsculas e substituindo caracteres especiais por hifens.
        String slug = input.toLowerCase().replaceAll("\\s+", "-").replaceAll("[^a-z0-9-]", "");
        return slug;
    }
}
