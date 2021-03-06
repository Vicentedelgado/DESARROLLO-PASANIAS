PGDMP         "                x            SPI_DATA    12.2    12.2 T    j           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            k           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            l           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            m           1262    25694    SPI_DATA    DATABASE     �   CREATE DATABASE "SPI_DATA" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "SPI_DATA";
                postgres    false            n           0    0    DATABASE "SPI_DATA"    COMMENT     <   COMMENT ON DATABASE "SPI_DATA" IS 'Base de datos Spis SDH';
                   postgres    false    2925            �            1259    25697    activo    TABLE     �   CREATE TABLE public.activo (
    idactivo integer NOT NULL,
    nombre character varying(100),
    idtipo integer,
    descripcion character varying(200)
);
    DROP TABLE public.activo;
       public         heap    postgres    false            �            1259    25695    activo_idactivo_seq    SEQUENCE     �   CREATE SEQUENCE public.activo_idactivo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.activo_idactivo_seq;
       public          postgres    false    203            o           0    0    activo_idactivo_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.activo_idactivo_seq OWNED BY public.activo.idactivo;
          public          postgres    false    202            �            1259    25816    distrito    TABLE     f   CREATE TABLE public.distrito (
    iddistrito bigint NOT NULL,
    distrito character varying(255)
);
    DROP TABLE public.distrito;
       public         heap    postgres    false            �            1259    25814    distrito_iddistrito_seq    SEQUENCE     �   CREATE SEQUENCE public.distrito_iddistrito_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.distrito_iddistrito_seq;
       public          postgres    false    217            p           0    0    distrito_iddistrito_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.distrito_iddistrito_seq OWNED BY public.distrito.iddistrito;
          public          postgres    false    216            �            1259    25707    institucion    TABLE     j   CREATE TABLE public.institucion (
    idinstitucion integer NOT NULL,
    nombre character varying(60)
);
    DROP TABLE public.institucion;
       public         heap    postgres    false            �            1259    25705    institucion_idinstitucion_seq    SEQUENCE     �   CREATE SEQUENCE public.institucion_idinstitucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.institucion_idinstitucion_seq;
       public          postgres    false    205            q           0    0    institucion_idinstitucion_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.institucion_idinstitucion_seq OWNED BY public.institucion.idinstitucion;
          public          postgres    false    204            �            1259    25716    registro_del_spi    TABLE     �  CREATE TABLE public.registro_del_spi (
    idregistro integer NOT NULL,
    idactivo integer,
    idspi integer,
    idinstitucion integer,
    estado character varying(10),
    cantidad numeric(4,0),
    cantidadrequerida numeric(4,0),
    holguradecantidad numeric(4,0),
    prioridad character varying(10),
    accionrealizada character varying(200),
    periodo character varying(15),
    fechaaccion date
);
 $   DROP TABLE public.registro_del_spi;
       public         heap    postgres    false            �            1259    25714    registro_del_spi_idregistro_seq    SEQUENCE     �   CREATE SEQUENCE public.registro_del_spi_idregistro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.registro_del_spi_idregistro_seq;
       public          postgres    false    207            r           0    0    registro_del_spi_idregistro_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.registro_del_spi_idregistro_seq OWNED BY public.registro_del_spi.idregistro;
          public          postgres    false    206            �            1259    25728    rrhh    TABLE     �  CREATE TABLE public.rrhh (
    idusuario integer NOT NULL,
    idspi integer,
    idzona integer,
    nombres character varying(60),
    apellidos character varying(60),
    cedula character varying(14),
    cargo character varying(30),
    direccion character varying(300),
    unidad character varying(100),
    estado character varying(15),
    telefono character varying(60),
    email character varying(50)
);
    DROP TABLE public.rrhh;
       public         heap    postgres    false            �            1259    25726    rrhh_idusuario_seq    SEQUENCE     �   CREATE SEQUENCE public.rrhh_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.rrhh_idusuario_seq;
       public          postgres    false    209            s           0    0    rrhh_idusuario_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.rrhh_idusuario_seq OWNED BY public.rrhh.idusuario;
          public          postgres    false    208            �            1259    25742 	   spi_datos    TABLE     x  CREATE TABLE public.spi_datos (
    idspi integer NOT NULL,
    idzona integer,
    idinstitucion integer,
    nombre character varying(60),
    direccion character varying(500),
    telefono character varying(20),
    numerodeoficina character varying(4),
    convenio character varying(4),
    daservicioa character varying(800),
    observaciones character varying(500)
);
    DROP TABLE public.spi_datos;
       public         heap    postgres    false            �            1259    25740    spi_datos_idspi_seq    SEQUENCE     �   CREATE SEQUENCE public.spi_datos_idspi_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.spi_datos_idspi_seq;
       public          postgres    false    211            t           0    0    spi_datos_idspi_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.spi_datos_idspi_seq OWNED BY public.spi_datos.idspi;
          public          postgres    false    210            �            1259    25756    tipo    TABLE     �   CREATE TABLE public.tipo (
    idtipo integer NOT NULL,
    nombre character varying(60),
    descripcion character varying(100)
);
    DROP TABLE public.tipo;
       public         heap    postgres    false            �            1259    25754    tipo_idtipo_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_idtipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tipo_idtipo_seq;
       public          postgres    false    213            u           0    0    tipo_idtipo_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.tipo_idtipo_seq OWNED BY public.tipo.idtipo;
          public          postgres    false    212            �            1259    25765    zona    TABLE     \   CREATE TABLE public.zona (
    idzona integer NOT NULL,
    nombre character varying(10)
);
    DROP TABLE public.zona;
       public         heap    postgres    false            �            1259    25763    zona_idzona_seq    SEQUENCE     �   CREATE SEQUENCE public.zona_idzona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.zona_idzona_seq;
       public          postgres    false    215            v           0    0    zona_idzona_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.zona_idzona_seq OWNED BY public.zona.idzona;
          public          postgres    false    214            �
           2604    25700    activo idactivo    DEFAULT     r   ALTER TABLE ONLY public.activo ALTER COLUMN idactivo SET DEFAULT nextval('public.activo_idactivo_seq'::regclass);
 >   ALTER TABLE public.activo ALTER COLUMN idactivo DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    25819    distrito iddistrito    DEFAULT     z   ALTER TABLE ONLY public.distrito ALTER COLUMN iddistrito SET DEFAULT nextval('public.distrito_iddistrito_seq'::regclass);
 B   ALTER TABLE public.distrito ALTER COLUMN iddistrito DROP DEFAULT;
       public          postgres    false    217    216    217            �
           2604    25710    institucion idinstitucion    DEFAULT     �   ALTER TABLE ONLY public.institucion ALTER COLUMN idinstitucion SET DEFAULT nextval('public.institucion_idinstitucion_seq'::regclass);
 H   ALTER TABLE public.institucion ALTER COLUMN idinstitucion DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    25719    registro_del_spi idregistro    DEFAULT     �   ALTER TABLE ONLY public.registro_del_spi ALTER COLUMN idregistro SET DEFAULT nextval('public.registro_del_spi_idregistro_seq'::regclass);
 J   ALTER TABLE public.registro_del_spi ALTER COLUMN idregistro DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    25731    rrhh idusuario    DEFAULT     p   ALTER TABLE ONLY public.rrhh ALTER COLUMN idusuario SET DEFAULT nextval('public.rrhh_idusuario_seq'::regclass);
 =   ALTER TABLE public.rrhh ALTER COLUMN idusuario DROP DEFAULT;
       public          postgres    false    208    209    209            �
           2604    25745    spi_datos idspi    DEFAULT     r   ALTER TABLE ONLY public.spi_datos ALTER COLUMN idspi SET DEFAULT nextval('public.spi_datos_idspi_seq'::regclass);
 >   ALTER TABLE public.spi_datos ALTER COLUMN idspi DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    25759    tipo idtipo    DEFAULT     j   ALTER TABLE ONLY public.tipo ALTER COLUMN idtipo SET DEFAULT nextval('public.tipo_idtipo_seq'::regclass);
 :   ALTER TABLE public.tipo ALTER COLUMN idtipo DROP DEFAULT;
       public          postgres    false    213    212    213            �
           2604    25768    zona idzona    DEFAULT     j   ALTER TABLE ONLY public.zona ALTER COLUMN idzona SET DEFAULT nextval('public.zona_idzona_seq'::regclass);
 :   ALTER TABLE public.zona ALTER COLUMN idzona DROP DEFAULT;
       public          postgres    false    214    215    215            Y          0    25697    activo 
   TABLE DATA           G   COPY public.activo (idactivo, nombre, idtipo, descripcion) FROM stdin;
    public          postgres    false    203   �`       g          0    25816    distrito 
   TABLE DATA           8   COPY public.distrito (iddistrito, distrito) FROM stdin;
    public          postgres    false    217   b       [          0    25707    institucion 
   TABLE DATA           <   COPY public.institucion (idinstitucion, nombre) FROM stdin;
    public          postgres    false    205   9b       ]          0    25716    registro_del_spi 
   TABLE DATA           �   COPY public.registro_del_spi (idregistro, idactivo, idspi, idinstitucion, estado, cantidad, cantidadrequerida, holguradecantidad, prioridad, accionrealizada, periodo, fechaaccion) FROM stdin;
    public          postgres    false    207   �c       _          0    25728    rrhh 
   TABLE DATA           �   COPY public.rrhh (idusuario, idspi, idzona, nombres, apellidos, cedula, cargo, direccion, unidad, estado, telefono, email) FROM stdin;
    public          postgres    false    209   �e       a          0    25742 	   spi_datos 
   TABLE DATA           �   COPY public.spi_datos (idspi, idzona, idinstitucion, nombre, direccion, telefono, numerodeoficina, convenio, daservicioa, observaciones) FROM stdin;
    public          postgres    false    211   {�       c          0    25756    tipo 
   TABLE DATA           ;   COPY public.tipo (idtipo, nombre, descripcion) FROM stdin;
    public          postgres    false    213   ��       e          0    25765    zona 
   TABLE DATA           .   COPY public.zona (idzona, nombre) FROM stdin;
    public          postgres    false    215   �       w           0    0    activo_idactivo_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.activo_idactivo_seq', 29, true);
          public          postgres    false    202            x           0    0    distrito_iddistrito_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.distrito_iddistrito_seq', 1, false);
          public          postgres    false    216            y           0    0    institucion_idinstitucion_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.institucion_idinstitucion_seq', 22, true);
          public          postgres    false    204            z           0    0    registro_del_spi_idregistro_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.registro_del_spi_idregistro_seq', 35, true);
          public          postgres    false    206            {           0    0    rrhh_idusuario_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.rrhh_idusuario_seq', 85, true);
          public          postgres    false    208            |           0    0    spi_datos_idspi_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.spi_datos_idspi_seq', 50, true);
          public          postgres    false    210            }           0    0    tipo_idtipo_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tipo_idtipo_seq', 1, false);
          public          postgres    false    212            ~           0    0    zona_idzona_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.zona_idzona_seq', 1, false);
          public          postgres    false    214            �
           2606    25821    distrito distrito_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_pkey PRIMARY KEY (iddistrito);
 @   ALTER TABLE ONLY public.distrito DROP CONSTRAINT distrito_pkey;
       public            postgres    false    217            �
           2606    25702    activo pk_activo 
   CONSTRAINT     T   ALTER TABLE ONLY public.activo
    ADD CONSTRAINT pk_activo PRIMARY KEY (idactivo);
 :   ALTER TABLE ONLY public.activo DROP CONSTRAINT pk_activo;
       public            postgres    false    203            �
           2606    25712    institucion pk_institucion 
   CONSTRAINT     c   ALTER TABLE ONLY public.institucion
    ADD CONSTRAINT pk_institucion PRIMARY KEY (idinstitucion);
 D   ALTER TABLE ONLY public.institucion DROP CONSTRAINT pk_institucion;
       public            postgres    false    205            �
           2606    25721 $   registro_del_spi pk_registro_del_spi 
   CONSTRAINT     j   ALTER TABLE ONLY public.registro_del_spi
    ADD CONSTRAINT pk_registro_del_spi PRIMARY KEY (idregistro);
 N   ALTER TABLE ONLY public.registro_del_spi DROP CONSTRAINT pk_registro_del_spi;
       public            postgres    false    207            �
           2606    25736    rrhh pk_rrhh 
   CONSTRAINT     Q   ALTER TABLE ONLY public.rrhh
    ADD CONSTRAINT pk_rrhh PRIMARY KEY (idusuario);
 6   ALTER TABLE ONLY public.rrhh DROP CONSTRAINT pk_rrhh;
       public            postgres    false    209            �
           2606    25750    spi_datos pk_spi_datos 
   CONSTRAINT     W   ALTER TABLE ONLY public.spi_datos
    ADD CONSTRAINT pk_spi_datos PRIMARY KEY (idspi);
 @   ALTER TABLE ONLY public.spi_datos DROP CONSTRAINT pk_spi_datos;
       public            postgres    false    211            �
           2606    25761    tipo pk_tipo 
   CONSTRAINT     N   ALTER TABLE ONLY public.tipo
    ADD CONSTRAINT pk_tipo PRIMARY KEY (idtipo);
 6   ALTER TABLE ONLY public.tipo DROP CONSTRAINT pk_tipo;
       public            postgres    false    213            �
           2606    25770    zona pk_zona 
   CONSTRAINT     N   ALTER TABLE ONLY public.zona
    ADD CONSTRAINT pk_zona PRIMARY KEY (idzona);
 6   ALTER TABLE ONLY public.zona DROP CONSTRAINT pk_zona;
       public            postgres    false    215            �
           1259    25723 	   activo_fk    INDEX     J   CREATE INDEX activo_fk ON public.registro_del_spi USING btree (idactivo);
    DROP INDEX public.activo_fk;
       public            postgres    false    207            �
           1259    25703 	   activo_pk    INDEX     G   CREATE UNIQUE INDEX activo_pk ON public.activo USING btree (idactivo);
    DROP INDEX public.activo_pk;
       public            postgres    false    203            �
           1259    25713    institucion_pk    INDEX     V   CREATE UNIQUE INDEX institucion_pk ON public.institucion USING btree (idinstitucion);
 "   DROP INDEX public.institucion_pk;
       public            postgres    false    205            �
           1259    25724    pertenencia2_fk    INDEX     U   CREATE INDEX pertenencia2_fk ON public.registro_del_spi USING btree (idinstitucion);
 #   DROP INDEX public.pertenencia2_fk;
       public            postgres    false    207            �
           1259    25752    pertenencia_fk    INDEX     M   CREATE INDEX pertenencia_fk ON public.spi_datos USING btree (idinstitucion);
 "   DROP INDEX public.pertenencia_fk;
       public            postgres    false    211            �
           1259    25722    registro_del_spi_pk    INDEX     ]   CREATE UNIQUE INDEX registro_del_spi_pk ON public.registro_del_spi USING btree (idregistro);
 '   DROP INDEX public.registro_del_spi_pk;
       public            postgres    false    207            �
           1259    25725    registro_fk    INDEX     I   CREATE INDEX registro_fk ON public.registro_del_spi USING btree (idspi);
    DROP INDEX public.registro_fk;
       public            postgres    false    207            �
           1259    25739    rrhh_fk    INDEX     :   CREATE INDEX rrhh_fk ON public.rrhh USING btree (idzona);
    DROP INDEX public.rrhh_fk;
       public            postgres    false    209            �
           1259    25737    rrhh_pk    INDEX     D   CREATE UNIQUE INDEX rrhh_pk ON public.rrhh USING btree (idusuario);
    DROP INDEX public.rrhh_pk;
       public            postgres    false    209            �
           1259    25751    spi_datos_pk    INDEX     J   CREATE UNIQUE INDEX spi_datos_pk ON public.spi_datos USING btree (idspi);
     DROP INDEX public.spi_datos_pk;
       public            postgres    false    211            �
           1259    25704    tipo_fk    INDEX     <   CREATE INDEX tipo_fk ON public.activo USING btree (idtipo);
    DROP INDEX public.tipo_fk;
       public            postgres    false    203            �
           1259    25762    tipo_pk    INDEX     A   CREATE UNIQUE INDEX tipo_pk ON public.tipo USING btree (idtipo);
    DROP INDEX public.tipo_pk;
       public            postgres    false    213            �
           1259    25738 
   usuario_fk    INDEX     <   CREATE INDEX usuario_fk ON public.rrhh USING btree (idspi);
    DROP INDEX public.usuario_fk;
       public            postgres    false    209            �
           1259    25753    zona_fk    INDEX     ?   CREATE INDEX zona_fk ON public.spi_datos USING btree (idzona);
    DROP INDEX public.zona_fk;
       public            postgres    false    211            �
           1259    25771    zona_pk    INDEX     A   CREATE UNIQUE INDEX zona_pk ON public.zona USING btree (idzona);
    DROP INDEX public.zona_pk;
       public            postgres    false    215            �
           2606    25772    activo fk_activo_tipo_tipo    FK CONSTRAINT     �   ALTER TABLE ONLY public.activo
    ADD CONSTRAINT fk_activo_tipo_tipo FOREIGN KEY (idtipo) REFERENCES public.tipo(idtipo) ON UPDATE RESTRICT ON DELETE RESTRICT;
 D   ALTER TABLE ONLY public.activo DROP CONSTRAINT fk_activo_tipo_tipo;
       public          postgres    false    203    2763    213            �
           2606    25777 *   registro_del_spi fk_registro_activo_activo    FK CONSTRAINT     �   ALTER TABLE ONLY public.registro_del_spi
    ADD CONSTRAINT fk_registro_activo_activo FOREIGN KEY (idactivo) REFERENCES public.activo(idactivo) ON UPDATE RESTRICT ON DELETE RESTRICT;
 T   ALTER TABLE ONLY public.registro_del_spi DROP CONSTRAINT fk_registro_activo_activo;
       public          postgres    false    207    2741    203            �
           2606    25782 /   registro_del_spi fk_registro_pertenenc_instituc    FK CONSTRAINT     �   ALTER TABLE ONLY public.registro_del_spi
    ADD CONSTRAINT fk_registro_pertenenc_instituc FOREIGN KEY (idinstitucion) REFERENCES public.institucion(idinstitucion) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Y   ALTER TABLE ONLY public.registro_del_spi DROP CONSTRAINT fk_registro_pertenenc_instituc;
       public          postgres    false    2745    207    205            �
           2606    25787 .   registro_del_spi fk_registro_registro_spi_dato    FK CONSTRAINT     �   ALTER TABLE ONLY public.registro_del_spi
    ADD CONSTRAINT fk_registro_registro_spi_dato FOREIGN KEY (idspi) REFERENCES public.spi_datos(idspi) ON UPDATE RESTRICT ON DELETE RESTRICT;
 X   ALTER TABLE ONLY public.registro_del_spi DROP CONSTRAINT fk_registro_registro_spi_dato;
       public          postgres    false    207    2759    211            �
           2606    25792    rrhh fk_rrhh_rrhh_zona    FK CONSTRAINT     �   ALTER TABLE ONLY public.rrhh
    ADD CONSTRAINT fk_rrhh_rrhh_zona FOREIGN KEY (idzona) REFERENCES public.zona(idzona) ON UPDATE RESTRICT ON DELETE RESTRICT;
 @   ALTER TABLE ONLY public.rrhh DROP CONSTRAINT fk_rrhh_rrhh_zona;
       public          postgres    false    209    2766    215            �
           2606    25797    rrhh fk_rrhh_usuario_spi_dato    FK CONSTRAINT     �   ALTER TABLE ONLY public.rrhh
    ADD CONSTRAINT fk_rrhh_usuario_spi_dato FOREIGN KEY (idspi) REFERENCES public.spi_datos(idspi) ON UPDATE RESTRICT ON DELETE RESTRICT;
 G   ALTER TABLE ONLY public.rrhh DROP CONSTRAINT fk_rrhh_usuario_spi_dato;
       public          postgres    false    211    2759    209            �
           2606    25802 (   spi_datos fk_spi_dato_pertenenc_instituc    FK CONSTRAINT     �   ALTER TABLE ONLY public.spi_datos
    ADD CONSTRAINT fk_spi_dato_pertenenc_instituc FOREIGN KEY (idinstitucion) REFERENCES public.institucion(idinstitucion) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.spi_datos DROP CONSTRAINT fk_spi_dato_pertenenc_instituc;
       public          postgres    false    205    2745    211            �
           2606    25807    spi_datos fk_spi_dato_zona_zona    FK CONSTRAINT     �   ALTER TABLE ONLY public.spi_datos
    ADD CONSTRAINT fk_spi_dato_zona_zona FOREIGN KEY (idzona) REFERENCES public.zona(idzona) ON UPDATE RESTRICT ON DELETE RESTRICT;
 I   ALTER TABLE ONLY public.spi_datos DROP CONSTRAINT fk_spi_dato_zona_zona;
       public          postgres    false    215    2766    211            Y   Q  x�m��n�0���S�Z���HQ��B�bb9�r��q2�6;0T<B^�v� *u���.w�<`�� ��Kò�B�������k��`X��$�̱���M���M�Q.�'*+�'ߛ�kw1��{���FS�� f��:�w_51Uf[.���D���:��/�"XH�l��5�=�a�ّZ,���k�g<4����L{)���?2Xce�j� �	���߽��t�h����x�ۣ�a�ʪ1�Τf���=7(�7���ʓ�f)%א�eˣ���LaM'�z�3��؝�K!�I�ʌ��C�⚧�U�Z}HC�V�Q$7�;����wo��      g      x������ � �      [   F  x�]QKN�0]ۧ���9�M:�c;΢�&R�T	eA�D,���n@"bi�{�>#XE:𜑭\A�����%_��PQ���� Z�©�K&�z��	�>*�XG�|5r}�h��]$�a�+��(i��P83�7Iu˂��*�3�HAb!�ΠDqpty�J�k�	 �p�6���c�	62�,�_3�m�GsXk�#,)*Thq�(������uC��b96�I*���S�G(�������t��G�0���c�t��'��fZ�_[��.��K�vН�l_��m�j�p8�����Ŗ�F�|��Xg���T:��:�0���9�Y��      ]   K  x��Uˎ�@<�|?�h��$�|X�q���2Z��A��U�!?��Ƽ",$#j�����L���.��)��ӥq,+�׶t�H	��� R�5� 9�m/�f�i<��c�ƗM��p� �cw��֗�
��ނT�0KGwEB��Wdk��C=�&�&Q]y��ȿ�����ʅ���"�-����|T{w�*�Ce�AZ
P�99���ߪ:B[r_�qJr���^!��bG#�R�4����ޗ�����@HL�����BQz�2�$g�}��Dd���b�v�����O���c�kr2��Svξ��Nk�a*���t.�Ձ*���F�u#d�Oƃ��p��ƅ�KC�����qM#�T!Md���xZ����
� \ah2�ڽWk��p$��E(^��CZ�1��[A�/�B��u��&�zH��'��)�݆�9:���`Dp���+��E����'��/��:7�Ƕ�-Ǟ M�iy}O��k8�>;�L�Ğ*�O�8�#� ��0���<��,-��J@�:~Nq�PrJ������g�����q-��`R�2�/�����C�}n|{��s�
���      _      x��[Mo�Ɩ]3��H6y������Ѳ�mG��6�� ��T��G�):#����a������E�f����*Jb�ݻI�t[�X�V�{�����������TY��
a<�|!�̋J>
É��"/p��J�ĳX��0��<�qш^\�ĉ9y.�i�*�̳WQ��/U���Y�EY,dn
3�BVr�$�CSsވE����(��:+�rT|l-�qUZ���/��ijL����~��A���*i�����Y?�����(��Z�3Kοs��"��0���L�����m.���Ҝ4�\�cہ��AlL�l��[^.�59ނ����"�9�:�&��Ӡ,��b]�^.M���ip�n'��8t�7@�^	 +�>Ԟ�u�}�y�g�4��5�5G�J�oۑ�x����f�����l��R<��i݊G�Q�⃹�1/D�"*���UU���J�ʤA#�Z�^ͪ�6�f%~Ů��ּ��g�����G��J
�z����]���cA��0��Y\t�n:q/|����W| 0|�{-�5�̘l?b���(����v���肢0Ge%�7w�j���tlnD�,k��Ƽ�Js,K�=�x�Zj�/2�l�\�_|�:Xb���$��R���oH��YK�V���+XrV�ג�8����Ǟ�լ,N�3% ޕU%k�B�d.j���7�xVb�#1�T4.p�ϢZd����ȶ}��K[�XeU?���ޅS1��KQeka�ɢ$�۲9�8n N�m��� �	7}]ᖃc6�����u���r,?� l�]�x\vT��؃�����b��,���	J�u �+��ZC�3,V��� +p� ��^�^��������^G���U)4}�#���IV8W�� G��\�
� z���}�2"��K�Ȏ9��g8�_�3��f8����Ў�؊���*�Ӈ�q�$=7�LW`��9&��w��j��c;G	:}81�ߧ�q�a��tl~0o�/��AzbN���9H����L�_ݏ�n�����]:���#s|�����>qw�N�i:�K��[���pd�o�����˻�����(qϋ|p�2�Z{�o�kİ�
)����p�1���&v���뺑kG�:���2���*��ޘ��,�)�����y�������v8���y?�<O����� ��|H���=_���A�@��$0����B��p0�<�ƾ#QlJ�b�ħ�c:��ƻJl('�*��|y��
��Ƽj���|���+���̝����8�b��U�%�⽐}#d��������7n�c{.�g|�x����Ο���7$�f�<e�d���ڡ�i3���ͳ�|�i���I��ۣ����/�?B��2o�CbQ�eo��R��B �� Y8�+ǥ
h��yg�H�j%�7�-�y��`��>
&~���!�C��=�&�x�X�w��06��y�]4.��m�1GvzG�k8����<<�w��z��z��	O�묢�«����
�Y)7�4)��~>8��!�z�!���y�r"��Jņ�j�hq��������v<D�����辫��G�LR�u�R(��M����9�sc��S����!>=��/4��`��z����0����q)�{��~|k�LI��F� �V���
o��!���R�l@�G�ZA��^�&�C= 5�r]/�Dú�pj#jY�� z��B�(Ym�I��#�1a��� MZ�i�,;1gZ؜I��WT0{�Ȟ�Ы�_�w�
W�2�P7y&��%�� [	�������ɬ[E��<J�n�c P*�����3�Cm�sU�B\��?��c��~NWȩ�
d����ˢ{����x���Y��G��ධ CnK��d�F��3?zm�pܮ :��=F����;�C"�ys`腍����.Q�D�5j�J�Dw�� ��?Z���W�{%�����f���g������,gr:�\�k��9�xG�W z�"����<I���Ӷ\3��
���f����!�^�M��i-����k��\�B!��k�֌Rm��yFf+�?�#P&JS���
J���@�`�6����r��;���,w���1���f�}�[  A]�P5!4% kT�F�c�����;���Z˂@[�#H�J�E>�N�,�} �_�Y�;��������Ƃ[�Rq��"�s���E��mC*�ՉV-�� R��Wb�}��@�,�t��`��� Q�d��Q�s����<
֭��8že��nk#�p\G�{�γ�d��^��Əg��g%I���4���v`��yq�uڮS3�H�	)�f�nf����zV��,J�ǘ�P�Z腎� z���/v����u�Z��R�J�B�;�Nh��K��>���\I�C�:�5U	�䨶:�Y�F�;X��L�%P���#�װ�#Y��5. :x�4f��p��� 8=
_7@rs���Tu?|�����6��!��9�����YK�b��݅���)�q&���Y~��)M�vQc������/+$��*(��sU~v�t�f[&�U/B���eQ�~�lz������ps���x�6"-��O9{�ج��P=�U���V����D��W�����w�*�T;�o�悉��6��w�"� �CK���h�j/^$V6��5ߝ�Z�#-eK��w=@�/ś��Hx	�3����E��G 0��
F��~�LJ��+ɲ�ذ�$t_�n�{V\����S����Sm�J�QMuD7��������$ �����{�݅�Y��@ץ��	?�{�^N"c�V�*�^/FdǘQ�͎m�m�䠺j(�ٹ��$6�go :s�0Y����?|TUv�����o��ņ��(�\l�aV�kز'��OR �B�[��Bv��]E�\�@&�����v�|@S�o�@���'ۏ�@��IY̥�(��c;>ڰUq}+k躲��x�`�YȒ1��^H4�&t���;͆�Q#�~�"�^����y^B������`1�"(*��kNhǑ}���`�S�v�T+�6a����n˜=����S��̡R��DA܎�t��E�?�ZBUS�fA���E;�Ah�����k��N�e�Ę#���<(d#�{�'}���x�T�-i�ӳآZ�y'U�!�:�|cz967��Û�<�0�c�J��_�,J�W60Q3�N�G�cRbe��s��-+'@"���#m����m����vO/���Џ��8(s����Xw�I)�b�[�h���8�3�#V����62A{Su _`%���d"���G<\՛A�𿩬P�����f*�x�mV��t[G�/LC�7�^\p�$Np_���?j�2�*t8��J>�GY�g<����{.�CQdC�$l�b�������Jd�5/W���{�Ů���YF���1
�8��g����<�=PG-�^J!��w� WEe�~��\TXx��A��z��cq5v��3D"-�/���~*�ML��a'������a��;�w�f����>�%��n�����Ʃ ���U��_2��|5+ş�Z���f��m��o���=��Uǅ\iGz8u��
L�#\;����;3u�a��J���	Lq�DG�ǜ��@:�˶=$\��A%}o,C]�@/d����y�"U� �
�u�o7������k��Tf�A n��qc��}�Љ!���UY	�c���1X`ө�PT��x�����Ĥ2u���
�xeq9�%�F�#�k���pAb[�G��\*NCf�o1:iL�L��R�c�A�ԫ�KV�;�F1�K�K�~h�.)��YA��f�=q��>Е��׎� ��ZUO���/.�A
�W�i��.�cD�J�H�7�\T�a��TŚRf��	eu��V�v""q�ѳ����H�9jX;����f��EpU��XV%���$	:�\TM���P�}���v��yG	��N-@�!#�De�E/~dj��㰕b.�|&�m�q@`�a+�[~�D���klW���r5�E�rϤa��Ö��,DrfS�Ir��\BG� |  �J4�>Ȋ}���v/NB'�&�fk����!o����6P������.�C7�������R��$C��z��oW��8��UɃ�����K�w�~
/��5�à�ż+m�8cޏ,J��+������mL�E��HT5��#���8L� �t��8��q��9ŉ�*����T`��(���y��&p¯�d(��6�<�"U��EN��Ȏ�MJ���"��(�L͆P�od�*â0�A�?>zN$d�5�$���k�V��X�J���Zf�	�7 ��%7��\�3‒32V
��R����9!���^���2o�Ğ���H�7�O%�?�K`G���PH��C�j�j���k��M^��>Rv޼Yo
C/h�@�
�9~T����z��dCN��+�r��B��=ި)I)�Uj�!sTnW��K����,W~X�� z�l���D;��Bw��ɐ�w5��k/�b�>�}�/σI�����w���k�*kr������"���t�V:���JUkus��r5%��4K�;�6��0���:��%C!r8���_�p&�(�m\�39�`�zQLSݧW�)6ԉ��w[|�Ӄ!��χ]@"A ��Cw�7�+Id��D{\��w�,�Mu��$��O ����fEڬ���|I7�z�DN�D��LΙpaQ]q��G�ջ� ��;�t%��մ��;9c��$�;ޜw�taD�,S�+���Qf�M�ׂ)�+�����Ĥ���5�^�c�\dP��������@]�_#�~V!�G ���%`mq�{9�*��A����:�ou�DJ�KX�F��8���I|$e��gКY�5���m7�ɀ����nr�섹>�.���
v]��o�N�$lo���lo�P�r��A�I��-�ȯL��Ȳ���b�������Ck�������D{)��߯y}V�?�-i}��:��j�������T׉C�uNH(������O�G��P�.�z-����M�(Ύ �A�m;��5�⓲n��=��X17�;Ba���^0G�QэZ��Kɥ�,-v�} ��
��u�����krmȠ�E�="o���q�d+J;���r���\���.��ncN�JK���S.*�)�N�̎�v/H��[֊���4��Z��3��q��.����e��	�-���N}��7"�9φ���1�1�5N�Ȩ��V���E�D� ���k5��g�]g8(�#;����Ɉɤr�,O�j��˰#Ǐ��16z�oQbh�w��cӦ�SQ0ۼ���V8�w��M���
���׺�b}���~�j�O@망���߲Uv��`������E�5a꫗^���c����E];�Z��*��+(Wߴ�b4:>� �;�������3��k����� �Ȏ����(բ��#x��f�$ǈ9#����VB%b��g4Mӣ\6l��6  �w^.�WIcRE~J�S��8���s����
�q�߅���F|P��W�o
�^5��7�l3��X�ZNE3��<����Z>��0�$
��9L�R���CKs$�B�KH0Ɇx�D�þ�	�|��4�N ��jm�lr�����{��C�ď0���zy�t�+N���،vҺ��hh!+Ʊ6t�)N�W���Em��?2˪���]s���Ln�C��:�.�eI� G�&�%ɵ: C�9^5+�\b�(\1\�vסɕB5���b�Pa�9Q/�7�K��� D}���HHh��~Q�����}P��@|;<�<�Q_z��z�$�w���2*�g�S�Xt��T!�YK��w��3�#��3)D%ܥ䅵j���e�t*�FGGZ[���m�IK3�^F�8[<8�����3����sk��8�n2D�E��n�b㍨����D_�xU�A����V�+���k��1����G��R)�Le�	�w��������&�x�vB��W�Kޙ|ч;^dE[��^��!�B���	��^Smj:˖"�;���r��f�8k��!A���3�Kȷ��� �:���SpՇݐ~�Y��Q�Q�U���5���R7��)�|�+�l�����j�צ��9f=����~ߣ6����J�&����a�����(���6��im�[-y��PQ�2f	넆U�B�4�BT_ր��5�S���g�pj'C;<
�*����s���yǏ���fx�	5䭜WR���������~@G��R�L#�Ek�w�������gd�E�lW�x���h/>\�K���v^�(�]�����_���8������;����7�
�����W�e�Q��Ȳ�H�$� ��$UA���!�5�n*7��8��S7U%_�Cl�ㄋ�j�ݼi|r
�xɞ�KwP-Aƃ/��Z4����� �r�{��]eO��"�T ���'�#� ;hEޥ��ܶ��[�g�s,���w��p/P��Z��G�G���^���v��88cCȱ��X/j�u��N��Կ�|���Н�s0�Nz>�ul��=`����@����A�y��NŒ`j�[]��,x]��o���x!���tQ���>ܚ�Pz����g�C���Dr�ᐾ\�1}	�{4�9[��Ōڈ].3��0�c��gW�����$����/n�U{�z,��.�M��l����`ޑ��<�f&;:eӦ1uI�/(�'(��䂻R��Cq��?^��A�5�@4�w��B��@.�N`GN@%(HV,�+_Y��W�.(O�d,\�Zem��=�{a;/����%�tu>4��)�>9�lf���pd��χۿ��R���B�{3�\��/��Rz~?���7���b��X*p�S"zg��@�n�R�M��%�b��ٛr�@}qǸ�~��D8C�1̦������.���Y��o?A�8�Ȋ�W�xk��g�RXr��?[�}���F-�       a   '  x�uY�v�]�_�er���C�#;[vw��Ci{��9�@$,Ç"4 ���˧x�/��.[�Xn@I=af��j� 
U�n�*��>�R��ʝ	��J�R��L�Rb+۷L�F�ۺ}��.E٬�5���x�@\f+Ίgi�/��O��*��r�JmD&��	�����V�[�������F���p�*d�Ѯ�~>�̌��bn�FW��Q��i<�:S�f�͚ߚ�} �z%Wk[����Ygɋ�j)��T�[��IL&��}-7�0�,/䩸�#J<13E!�����q}).k��i�,
�{+m���+{m�rk�F�i�Ԏ,�ƣd�:K�l[�Lf/z �p��}K8T�M��W�9n�o/qn����@$*����+C�/��-_v�^]>�-qM����V��.��z�A�h�7�ĭ)��?���s#�~*ẓ�E��"�����r%�jUf��^"�Mx��l�(��Y�(����_L���+q�ltA�>/.)��}��\�R�t��T�6�J��YU'#�r� ���Й`JD:+�l
�_��wc�'S�-q�~_���lǃQ�eS�F��G��4�C�M֬���0�;��d˂l=�2/M��<�2�䠺Yɭ�k��p�(	 �	�P.+_�8�����hA��۷2k���Ɂe�V#����t<�����Y{�Z�&<�
v���C(�^���{
��\���Z� �9�a�#H�RR\�*
>>>\|>=q0d����F���i]y��Z��5��8V��QN�����]����M�p���3�- 2���HU��5�����w2	��B��C>��O�`���E�&�\��,��K�J���]�!�GHA&��ρ@��p�N��!йB��=X� eV7� �w��'S��
�`�
�*K��\Vp�C�-��N�p:
�a2LCw�����|z��C�Tj��ţ)(�=�k����<3웙�,�B6
�4+��tj�o��ʱu��K��EΌ��(�O�d�$Q2�Ĥ^���#�}zΊ8j3�����0�y�[�I&�	��p�|q^t�8�"�S�3�>����M�^*)jU�gت3�"�
F���X�XYi��@���	@�Kk�w��p8���0�T.������S��نR���^-QR]���D��o��1#��8���F��#QJ���V��5�*��>QC�����W���>��"�~��5ҡ�aw���Q�lq�<ҁ�c��(q�ר��Cp�:@�Z�i�}�t�-m�s���}|�.K$��5y���.������m�����$%IGut��~*�Y>����~�lѕ��0+].��?�&^#xbN�訰������[�[E.NF�0(�1������}�Lٚ���~bFE%�r+.�3����\��D���p�Q�H��C�~�E����&�d4
�U|�@|,䆨�+>"i��:�)�=��4$Qi*RS=7@R�O\�6�����s,P�>�$P⪢2� C��gd�&��e־?댊�h2��v,/���9>���~�}!��#�-e)���t:�hE�Ή߹��e$~N5
�Z��'�����й�ĝY��K��&c���Mѧw`���\����7�l%�h_�Κ��.و�}[�(vD!h����A�)vZ�B����՚�Ƭ8�В�"9@�4���֐�t�
���X�+��,��>>�S�ʭ���?")�5�weX>Zݔ�����+���J�u��A�(Y��E%�bh��@�B�e��2q�@��7z�FCKm@l�?P��<�P�%���4��`F��<Dh����(�G
G���6dy�($Uꏊ+t	�0��q�;".��5���r!_��ג�_�|vR�	�B[oɒ(L�t:K�E�1e���'��%7'?Y�~U;�_$�P3zm���1ý��,��=�.,X�c翴f����g8Bs��e���F��k�S����La�$@� y'��N`�gU�4#TvG��j�ݚk�A���Hb���;jx�I	5f�k�J�m��+��������F%�
�I4���A[nT���ʖ0�t�qU��3�m�F� ��Q_X��ގe��ܣz��$�pi_���eMh�a�Lr)�
!�2��AFq<9��!��2Iq^������0N�tD�D!�([R�.+��5/f��v4�������,��a�����0�=�/�~=RM/
�|1��&�xt�졡��$�^[�0B�>�������+�
�j�A�|+�W��W��6D���a
F;+ݖDM�<}2'k�CR��V��.�93KJ����]>��%�/u��W��!��P�; ����X���F?�a�8J&���a�C$k�s�C�ǽW��ʽ�#b���x�ё��$�����fG�_ij����$e�q4%�L�l$_T�U1�`'ųk��l�-apc^]r�[��I�_�߭�4_�:��8N��x���i19¢���@-�RvB��?J�];������3����H�\ro�@��
B @���4c����w��t�Ĳkh;�;��G��x�� �r�����"[����v�j�-)I]*�^�C�87��e�6�Rg_nϘ����R����!ɏ�����0�ZQ!�-~��E�:�n�U�c��'�N@	D��׏paO�Lm��n�7��;v���x�ǘ�T~�&�5)�݉7r�p�wC�$�ewru|�.��L9�&��_�e�i�c]����Ls�]���p��(���'�R0���)������GgNRaN��ad��Q�K>�h��#�i�N�ů�*
�mH���Q�:�sȀ�*Kt_���V8��e ��S���*�y���.ҳ��)�!5E����hOb]�U?��:�nz� 0]u��~�s
3��I�����Y��+�p�)�M�8F������GT�L{�����5MlI]<�B�ID�@����Y�X���X�-�/|C��n0x�����W:�;��GZt��<�%O_�&�0洽C�U���Hї�r�����:wj��4�d��[߹� ��n��I^ڠ�b�%��e�m��:whBoK�������A�"�I�Q�[Ֆ��񇱛�/,b+P�jYDua"x"2T��f�8�ي���4t��a���MsE@��M8����0�0:�W��	�1�ZYn�x[�C))o������O�hpלv��t!J+�/�7�������ҋ���gS��d�%��~]���-UEW4���c�$�^�?S�h/�N�}D�[���]�|H�.;�P"6�������i8N������KY�[|�}�Ym"�����!�Zg�ထ&i�ep�q��y�o�h'��R9�b�M�K_����R�[*�[��
l���V�K^~�0��}C�$���3�"��l��>�[.��_@��\M����ًzv]+�Gtk@_��&GQp���z��f'��C4ܿ�:WT'�$�&�G\����˽)<�ꯖ$K�7��ߴ���$���gN�o��~�9o�|�(U�c*���Z8�����F�C�s�Q� ����J׼A�Q�y��D�q&��|40��_�����,=r�8��G(N��͒ߚ�8�ģ(�¡��>I4�Fj�Ћ��WA�H����7ܟ�^;���0��X��7�4	@�m4����YJ�/Cu�scQ7<�~ll�O�SZ����_8�c�b�"Q
��c!�����Ҭ�f�~�{u��U�٫zA־����1eљ�C���+�R��0��#sބ�����_�*��Wrh��^Vk�an����ӓ���]Yo      c   O   x�3���+.I�IL���K-���2�t�L���9]K3��N��"Ӕ�7�,3'3%1�5�t�N.�,����qqq :)�      e   :   x�%ƻ E�ةBf�ߣ#� �g���ZX�hd%S�BU*Mit��3��T&;���     