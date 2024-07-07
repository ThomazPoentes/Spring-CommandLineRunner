package br.com.thomaz.screnmatch.Service;

public interface IConvertDAdos {

    <T> T obterDados(String json, Class<T> classe);
}
