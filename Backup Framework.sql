PGDMP         *                {         	   hibernate    15.3    15.3 *    ;           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            <           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            =           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            >           1262    16470 	   hibernate    DATABASE     �   CREATE DATABASE hibernate WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE hibernate;
                postgres    false            �            1259    16588    agendamento    TABLE     �   CREATE TABLE public.agendamento (
    id bigint NOT NULL,
    datahora timestamp without time zone,
    obs character varying(255),
    valortotal numeric(19,2),
    id_pet bigint,
    id_usuario bigint
);
    DROP TABLE public.agendamento;
       public         heap    postgres    false            �            1259    16680    agendamentoservico    TABLE     �   CREATE TABLE public.agendamentoservico (
    id bigint NOT NULL,
    valorunitario numeric(19,2),
    id_agendamento bigint,
    id_servico bigint
);
 &   DROP TABLE public.agendamentoservico;
       public         heap    postgres    false            �            1259    16598    cidade    TABLE     u   CREATE TABLE public.cidade (
    cod_ibge bigint NOT NULL,
    nome character varying(120),
    cod_estado bigint
);
    DROP TABLE public.cidade;
       public         heap    postgres    false            �            1259    16603    cliente    TABLE     �   CREATE TABLE public.cliente (
    idcliente bigint NOT NULL,
    ativo boolean,
    cpf character varying(255),
    email character varying(255),
    nome character varying(120)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    16610    endereco    TABLE     �   CREATE TABLE public.endereco (
    idendereco bigint NOT NULL,
    bairro character varying(60),
    cep character varying(9),
    logradouro character varying(120),
    numero character varying(10),
    id_cidade bigint,
    id_cliente bigint
);
    DROP TABLE public.endereco;
       public         heap    postgres    false            �            1259    16615    estado    TABLE     |   CREATE TABLE public.estado (
    codigo bigint NOT NULL,
    nome character varying(120),
    sigla character varying(2)
);
    DROP TABLE public.estado;
       public         heap    postgres    false            �            1259    16639    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16620    pet    TABLE     �   CREATE TABLE public.pet (
    id bigint NOT NULL,
    nome character varying(255),
    observacao character varying(255),
    sexo character varying(255),
    tamanho character varying(255),
    id_cliente bigint
);
    DROP TABLE public.pet;
       public         heap    postgres    false            �            1259    16685    servico    TABLE     u   CREATE TABLE public.servico (
    id bigint NOT NULL,
    descricao character varying(60),
    valor numeric(7,2)
);
    DROP TABLE public.servico;
       public         heap    postgres    false            �            1259    16632    usuario    TABLE     �   CREATE TABLE public.usuario (
    id bigint NOT NULL,
    ativo boolean,
    nome character varying(20) NOT NULL,
    senha character varying(10) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            /          0    16588    agendamento 
   TABLE DATA           X   COPY public.agendamento (id, datahora, obs, valortotal, id_pet, id_usuario) FROM stdin;
    public          postgres    false    214   �1       7          0    16680    agendamentoservico 
   TABLE DATA           [   COPY public.agendamentoservico (id, valorunitario, id_agendamento, id_servico) FROM stdin;
    public          postgres    false    222   �1       0          0    16598    cidade 
   TABLE DATA           <   COPY public.cidade (cod_ibge, nome, cod_estado) FROM stdin;
    public          postgres    false    215   62       1          0    16603    cliente 
   TABLE DATA           E   COPY public.cliente (idcliente, ativo, cpf, email, nome) FROM stdin;
    public          postgres    false    216   S2       2          0    16610    endereco 
   TABLE DATA           f   COPY public.endereco (idendereco, bairro, cep, logradouro, numero, id_cidade, id_cliente) FROM stdin;
    public          postgres    false    217   3       3          0    16615    estado 
   TABLE DATA           5   COPY public.estado (codigo, nome, sigla) FROM stdin;
    public          postgres    false    218   #3       4          0    16620    pet 
   TABLE DATA           N   COPY public.pet (id, nome, observacao, sexo, tamanho, id_cliente) FROM stdin;
    public          postgres    false    219   @3       8          0    16685    servico 
   TABLE DATA           7   COPY public.servico (id, descricao, valor) FROM stdin;
    public          postgres    false    223   �3       5          0    16632    usuario 
   TABLE DATA           9   COPY public.usuario (id, ativo, nome, senha) FROM stdin;
    public          postgres    false    220   �3       ?           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 43, true);
          public          postgres    false    221            �           2606    16592    agendamento agendamento_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.agendamento
    ADD CONSTRAINT agendamento_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.agendamento DROP CONSTRAINT agendamento_pkey;
       public            postgres    false    214            �           2606    16684 *   agendamentoservico agendamentoservico_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.agendamentoservico
    ADD CONSTRAINT agendamentoservico_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.agendamentoservico DROP CONSTRAINT agendamentoservico_pkey;
       public            postgres    false    222            �           2606    16602    cidade cidade_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (cod_ibge);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public            postgres    false    215            �           2606    16609    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    216            �           2606    16614    endereco endereco_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (idendereco);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public            postgres    false    217            �           2606    16619    estado estado_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (codigo);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public            postgres    false    218            �           2606    16626    pet pet_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.pet
    ADD CONSTRAINT pet_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.pet DROP CONSTRAINT pet_pkey;
       public            postgres    false    219            �           2606    16689    servico servico_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.servico DROP CONSTRAINT servico_pkey;
       public            postgres    false    223            �           2606    16638 $   cliente uk_62uiuvr9jpnkok8sve9l23dvg 
   CONSTRAINT     ^   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT uk_62uiuvr9jpnkok8sve9l23dvg UNIQUE (cpf);
 N   ALTER TABLE ONLY public.cliente DROP CONSTRAINT uk_62uiuvr9jpnkok8sve9l23dvg;
       public            postgres    false    216            �           2606    16636    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    220            �           2606    16645 '   agendamento fk6fsrijsknwk5ebbpq4ij0u1xw    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamento
    ADD CONSTRAINT fk6fsrijsknwk5ebbpq4ij0u1xw FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);
 Q   ALTER TABLE ONLY public.agendamento DROP CONSTRAINT fk6fsrijsknwk5ebbpq4ij0u1xw;
       public          postgres    false    3220    220    214            �           2606    16695 .   agendamentoservico fk8jbxvfjdnnd25r5uuln3isnwl    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamentoservico
    ADD CONSTRAINT fk8jbxvfjdnnd25r5uuln3isnwl FOREIGN KEY (id_servico) REFERENCES public.servico(id);
 X   ALTER TABLE ONLY public.agendamentoservico DROP CONSTRAINT fk8jbxvfjdnnd25r5uuln3isnwl;
       public          postgres    false    222    3224    223            �           2606    16675    pet fk92cyr4va8b9x2madre83mpvkh    FK CONSTRAINT     �   ALTER TABLE ONLY public.pet
    ADD CONSTRAINT fk92cyr4va8b9x2madre83mpvkh FOREIGN KEY (id_cliente) REFERENCES public.cliente(idcliente);
 I   ALTER TABLE ONLY public.pet DROP CONSTRAINT fk92cyr4va8b9x2madre83mpvkh;
       public          postgres    false    216    3210    219            �           2606    16665 #   endereco fk9kfv2ojnna0ywwe0t601f1kn    FK CONSTRAINT     �   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT fk9kfv2ojnna0ywwe0t601f1kn FOREIGN KEY (id_cidade) REFERENCES public.cidade(cod_ibge);
 M   ALTER TABLE ONLY public.endereco DROP CONSTRAINT fk9kfv2ojnna0ywwe0t601f1kn;
       public          postgres    false    217    215    3208            �           2606    16670 $   endereco fkblowj6gkb8nfh9i07j6koml33    FK CONSTRAINT     �   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT fkblowj6gkb8nfh9i07j6koml33 FOREIGN KEY (id_cliente) REFERENCES public.cliente(idcliente);
 N   ALTER TABLE ONLY public.endereco DROP CONSTRAINT fkblowj6gkb8nfh9i07j6koml33;
       public          postgres    false    3210    217    216            �           2606    16690 .   agendamentoservico fklt051r2u7107aibbcu2052jnu    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamentoservico
    ADD CONSTRAINT fklt051r2u7107aibbcu2052jnu FOREIGN KEY (id_agendamento) REFERENCES public.agendamento(id);
 X   ALTER TABLE ONLY public.agendamentoservico DROP CONSTRAINT fklt051r2u7107aibbcu2052jnu;
       public          postgres    false    214    3206    222            �           2606    16640 '   agendamento fkp54qpvfkc8dr4qh2r2ckp1ykw    FK CONSTRAINT     �   ALTER TABLE ONLY public.agendamento
    ADD CONSTRAINT fkp54qpvfkc8dr4qh2r2ckp1ykw FOREIGN KEY (id_pet) REFERENCES public.pet(id);
 Q   ALTER TABLE ONLY public.agendamento DROP CONSTRAINT fkp54qpvfkc8dr4qh2r2ckp1ykw;
       public          postgres    false    3218    219    214            �           2606    16660 "   cidade fkqbnh7ry4uxdjrhakpons3jct5    FK CONSTRAINT     �   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT fkqbnh7ry4uxdjrhakpons3jct5 FOREIGN KEY (cod_estado) REFERENCES public.estado(codigo);
 L   ALTER TABLE ONLY public.cidade DROP CONSTRAINT fkqbnh7ry4uxdjrhakpons3jct5;
       public          postgres    false    215    218    3216            /   Q   x�U̱� D�ڞ�@�À�����!I�g�ɄD�E�ڌ Y�X+1���c+ψz:�U�(��Sc�O���CWQ�+��      7   :   x�5��� ��=r� `���j�>O�@�!�B,z�\��.�{+ޭDJ�ܼ��`^      0      x������ � �      1   �   x�U���0���Ð��l���L�pA�q	����S�I/����[��VHG0�'�ZY�(x�9񹶏��>�Ր�]Dw��Fle�3q͍���1��Xt�4��U�)��yM��kXr���rrXs��� -�������1�V92��ۚf�S���n�W      2      x������ � �      3      x������ � �      4   e   x�34��*���/���/*���M,N.�����H-,M��\FF�NE�@�Sj�B���ə9Xՙp�%�$r���$*��*����q���f�(������ 9�(m      8   9   x�34�tJ����44�30�22�,KL��K�45 �-8�3�J��39��B1z\\\ y��      5      x������ � �     