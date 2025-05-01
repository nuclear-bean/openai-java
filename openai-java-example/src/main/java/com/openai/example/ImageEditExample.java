package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.images.Image;
import com.openai.models.images.ImageEditParams;
import com.openai.models.images.ImageModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public final class ImageEditExample {
    private ImageEditExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using one of:
        // - The OPENAI_API_KEY environment variable
        // - The OPENAI_BASE_URL and AZURE_OPENAI_KEY environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String filename = "aloha.png";
        InputStream pngStream = classloader.getResourceAsStream(filename);

        String maskFilename = "aloha-mask.png";
        InputStream maskStream = classloader.getResourceAsStream(maskFilename);

        if (pngStream == null || maskStream == null) {
            throw new IllegalArgumentException("Image or mask not found in resources.");
        }

        ImageEditParams.Image image = ImageEditParams.Image.ofInputStream(pngStream);

        ImageEditParams imageEditParams = ImageEditParams.builder()
                .responseFormat(ImageEditParams.ResponseFormat.URL)
                .image(image)
                .mask(maskStream)
                .prompt("Fill the mask area with sand.")
                .model(ImageModel.DALL_E_2)
                .n(1)
                .build();

        client.images().edit(imageEditParams).data().orElseThrow(IOException::new).stream()
                .map(Image::url)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}