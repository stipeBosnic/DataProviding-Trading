--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-04-04 15:36:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 66060)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    category_id bigint NOT NULL,
    category_name character varying(255) NOT NULL,
    sport_id integer NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 66059)
-- Name: category_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_category_id_seq OWNER TO postgres;

--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 210
-- Name: category_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_category_id_seq OWNED BY public.category.category_id;


--
-- TOC entry 209 (class 1259 OID 66050)
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.market (
    market_id bigint NOT NULL,
    marketstate bigint NOT NULL,
    market_type bigint NOT NULL,
    match_id bigint NOT NULL
);

ALTER TABLE public.market OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 66066)
-- Name: market_market_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.market_market_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.market_market_id_seq OWNER TO postgres;

--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 212
-- Name: market_market_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.market_market_id_seq OWNED BY public.market.market_id;


--
-- TOC entry 215 (class 1259 OID 66074)
-- Name: marketpick; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marketpick (
    marketpick_id bigint NOT NULL,
    market_id integer NOT NULL,
    odd double precision NOT NULL,
    marketpick character varying(255) NOT NULL,
    CONSTRAINT marketpick_odd_check CHECK ((odd >= (1)::double precision))
);


ALTER TABLE public.marketpick OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 66073)
-- Name: marketpick_marketpick_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marketpick_marketpick_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marketpick_marketpick_id_seq OWNER TO postgres;

--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 214
-- Name: marketpick_marketpick_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marketpick_marketpick_id_seq OWNED BY public.marketpick.marketpick_id;


--
-- TOC entry 217 (class 1259 OID 66082)
-- Name: marketstate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marketstate (
    marketstate_id bigint NOT NULL,
    market_state character varying(255) NOT NULL
);


ALTER TABLE public.marketstate OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 66081)
-- Name: marketstate_marketstate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marketstate_marketstate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marketstate_marketstate_id_seq OWNER TO postgres;

--
-- TOC entry 3416 (class 0 OID 0)
-- Dependencies: 216
-- Name: marketstate_marketstate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.marketstate_marketstate_id_seq OWNED BY public.marketstate.marketstate_id;


--
-- TOC entry 219 (class 1259 OID 66089)
-- Name: markettype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.markettype (
    market_type_id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.markettype OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 66088)
-- Name: markettype_market_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.markettype_market_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.markettype_market_type_id_seq OWNER TO postgres;

--
-- TOC entry 3417 (class 0 OID 0)
-- Dependencies: 218
-- Name: markettype_market_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.markettype_market_type_id_seq OWNED BY public.markettype.market_type_id;


--
-- TOC entry 221 (class 1259 OID 66096)
-- Name: match; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.match (
    match_id bigint NOT NULL,
    provider_id uuid,
    start_time timestamp without time zone NOT NULL,
    tournament_id integer NOT NULL,
    away_team bigint NOT NULL,
    home_team bigint NOT NULL,
    CONSTRAINT match_tournament_id_check CHECK ((tournament_id >= 1))
);


ALTER TABLE public.match OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 66095)
-- Name: match_match_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.match_match_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.match_match_id_seq OWNER TO postgres;

--
-- TOC entry 3418 (class 0 OID 0)
-- Dependencies: 220
-- Name: match_match_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.match_match_id_seq OWNED BY public.match.match_id;


--
-- TOC entry 223 (class 1259 OID 66104)
-- Name: sport; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sport (
    sport_id integer NOT NULL,
    sport_name character varying(255) NOT NULL
);


ALTER TABLE public.sport OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 66103)
-- Name: sport_sport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sport_sport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sport_sport_id_seq OWNER TO postgres;

--
-- TOC entry 3419 (class 0 OID 0)
-- Dependencies: 222
-- Name: sport_sport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sport_sport_id_seq OWNED BY public.sport.sport_id;


--
-- TOC entry 225 (class 1259 OID 66111)
-- Name: team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team (
    team_id bigint NOT NULL,
    team_name character varying(255) NOT NULL
);


ALTER TABLE public.team OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 66110)
-- Name: team_team_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.team_team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.team_team_id_seq OWNER TO postgres;

--
-- TOC entry 3420 (class 0 OID 0)
-- Dependencies: 224
-- Name: team_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.team_team_id_seq OWNED BY public.team.team_id;


--
-- TOC entry 227 (class 1259 OID 66118)
-- Name: tournament; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tournament (
    tournament_id bigint NOT NULL,
    category_id integer NOT NULL,
    tournament_name character varying(255) NOT NULL
);


ALTER TABLE public.tournament OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 66117)
-- Name: tournament_tournament_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tournament_tournament_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tournament_tournament_id_seq OWNER TO postgres;

--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 226
-- Name: tournament_tournament_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tournament_tournament_id_seq OWNED BY public.tournament.tournament_id;


--
-- TOC entry 3209 (class 2604 OID 66063)
-- Name: category category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN category_id SET DEFAULT nextval('public.category_category_id_seq'::regclass);


--
-- TOC entry 3210 (class 2604 OID 66070)
-- Name: market market_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.market ALTER COLUMN market_id SET DEFAULT nextval('public.market_market_id_seq'::regclass);


--
-- TOC entry 3211 (class 2604 OID 66077)
-- Name: marketpick marketpick_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marketpick ALTER COLUMN marketpick_id SET DEFAULT nextval('public.marketpick_marketpick_id_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 66085)
-- Name: marketstate marketstate_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marketstate ALTER COLUMN marketstate_id SET DEFAULT nextval('public.marketstate_marketstate_id_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 66092)
-- Name: markettype market_type_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.markettype ALTER COLUMN market_type_id SET DEFAULT nextval('public.markettype_market_type_id_seq'::regclass);


--
-- TOC entry 3215 (class 2604 OID 66099)
-- Name: match match_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match ALTER COLUMN match_id SET DEFAULT nextval('public.match_match_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 66107)
-- Name: sport sport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sport ALTER COLUMN sport_id SET DEFAULT nextval('public.sport_sport_id_seq'::regclass);


--
-- TOC entry 3218 (class 2604 OID 66114)
-- Name: team team_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team ALTER COLUMN team_id SET DEFAULT nextval('public.team_team_id_seq'::regclass);


--
-- TOC entry 3219 (class 2604 OID 66121)
-- Name: tournament tournament_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tournament ALTER COLUMN tournament_id SET DEFAULT nextval('public.tournament_tournament_id_seq'::regclass);


--
-- TOC entry 3391 (class 0 OID 66060)
-- Dependencies: 211
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (category_id, category_name, sport_id) FROM stdin;
\.


--
-- TOC entry 3389 (class 0 OID 66050)
-- Dependencies: 209
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	2	updateTable	SQL	V2__updateTable.sql	0	postgres	2022-04-04 15:35:49.793743	7	t
\.


--
-- TOC entry 3393 (class 0 OID 66067)
-- Dependencies: 213
-- Data for Name: market; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.market (market_id, marketstate, market_type, match_id) FROM stdin;
\.


--
-- TOC entry 3395 (class 0 OID 66074)
-- Dependencies: 215
-- Data for Name: marketpick; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marketpick (marketpick_id, market_id, odd, marketpick) FROM stdin;
\.


--
-- TOC entry 3397 (class 0 OID 66082)
-- Dependencies: 217
-- Data for Name: marketstate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marketstate (marketstate_id, market_state) FROM stdin;
\.


--
-- TOC entry 3399 (class 0 OID 66089)
-- Dependencies: 219
-- Data for Name: markettype; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.markettype (market_type_id, name) FROM stdin;
\.


--
-- TOC entry 3401 (class 0 OID 66096)
-- Dependencies: 221
-- Data for Name: match; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.match (match_id, provider_id, start_time, tournament_id, away_team, home_team) FROM stdin;
\.


--
-- TOC entry 3403 (class 0 OID 66104)
-- Dependencies: 223
-- Data for Name: sport; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sport (sport_id, sport_name) FROM stdin;
\.


--
-- TOC entry 3405 (class 0 OID 66111)
-- Dependencies: 225
-- Data for Name: team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team (team_id, team_name) FROM stdin;
\.


--
-- TOC entry 3407 (class 0 OID 66118)
-- Dependencies: 227
-- Data for Name: tournament; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tournament (tournament_id, category_id, tournament_name) FROM stdin;
\.


--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 210
-- Name: category_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_category_id_seq', 1, false);


--
-- TOC entry 3423 (class 0 OID 0)
-- Dependencies: 212
-- Name: market_market_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.market_market_id_seq', 1, false);


--
-- TOC entry 3424 (class 0 OID 0)
-- Dependencies: 214
-- Name: marketpick_marketpick_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marketpick_marketpick_id_seq', 1, false);


--
-- TOC entry 3425 (class 0 OID 0)
-- Dependencies: 216
-- Name: marketstate_marketstate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marketstate_marketstate_id_seq', 1, false);


--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 218
-- Name: markettype_market_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.markettype_market_type_id_seq', 1, false);


--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 220
-- Name: match_match_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.match_match_id_seq', 1, false);


--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 222
-- Name: sport_sport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sport_sport_id_seq', 1, false);


--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 224
-- Name: team_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.team_team_id_seq', 1, false);


--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 226
-- Name: tournament_tournament_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tournament_tournament_id_seq', 1, false);


--
-- TOC entry 3224 (class 2606 OID 66065)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


--
-- TOC entry 3221 (class 2606 OID 66057)
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--
--
-- TOC entry 3226 (class 2606 OID 66072)
-- Name: market market_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.market
    ADD CONSTRAINT market_pkey PRIMARY KEY (market_id);


--
-- TOC entry 3228 (class 2606 OID 66080)
-- Name: marketpick marketpick_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marketpick
    ADD CONSTRAINT marketpick_pkey PRIMARY KEY (marketpick_id);


--
-- TOC entry 3230 (class 2606 OID 66087)
-- Name: marketstate marketstate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marketstate
    ADD CONSTRAINT marketstate_pkey PRIMARY KEY (marketstate_id);


--
-- TOC entry 3232 (class 2606 OID 66094)
-- Name: markettype markettype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.markettype
    ADD CONSTRAINT markettype_pkey PRIMARY KEY (market_type_id);


--
-- TOC entry 3234 (class 2606 OID 66102)
-- Name: match match_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT match_pkey PRIMARY KEY (match_id);


--
-- TOC entry 3236 (class 2606 OID 66109)
-- Name: sport sport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sport
    ADD CONSTRAINT sport_pkey PRIMARY KEY (sport_id);


--
-- TOC entry 3238 (class 2606 OID 66116)
-- Name: team team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_pkey PRIMARY KEY (team_id);


--
-- TOC entry 3240 (class 2606 OID 66123)
-- Name: tournament tournament_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tournament
    ADD CONSTRAINT tournament_pkey PRIMARY KEY (tournament_id);

--
-- TOC entry 3243 (class 2606 OID 66134)
-- Name: market fk1xd9t72tomvmu1m88j06fgddn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.market
    ADD CONSTRAINT fk1xd9t72tomvmu1m88j06fgddn FOREIGN KEY (market_type) REFERENCES public.markettype(market_type_id);


--
-- TOC entry 3248 (class 2606 OID 66159)
-- Name: match fk3o2flmlku9l351xpvof8aw8oi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fk3o2flmlku9l351xpvof8aw8oi FOREIGN KEY (tournament_id) REFERENCES public.tournament(tournament_id);


--
-- TOC entry 3241 (class 2606 OID 66124)
-- Name: category fk75iwgfu3tye569b7ybmxqvsul; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT fk75iwgfu3tye569b7ybmxqvsul FOREIGN KEY (sport_id) REFERENCES public.sport(sport_id);


--
-- TOC entry 3242 (class 2606 OID 66129)
-- Name: market fk9eohn4qsfw9704mwrjf4gu6r3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.market
    ADD CONSTRAINT fk9eohn4qsfw9704mwrjf4gu6r3 FOREIGN KEY (marketstate) REFERENCES public.marketstate(marketstate_id);


--
-- TOC entry 3246 (class 2606 OID 66149)
-- Name: match fkad3kaeas880iq1nqkap3m07ur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fkad3kaeas880iq1nqkap3m07ur FOREIGN KEY (away_team) REFERENCES public.team(team_id);


--
-- TOC entry 3244 (class 2606 OID 66139)
-- Name: market fkb9l38inc85pfbl5h5qj8871p4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.market
    ADD CONSTRAINT fkb9l38inc85pfbl5h5qj8871p4 FOREIGN KEY (match_id) REFERENCES public.match(match_id);


--
-- TOC entry 3247 (class 2606 OID 66154)
-- Name: match fkdtyj3wfqq8cvd8nxreyjcrmdi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT fkdtyj3wfqq8cvd8nxreyjcrmdi FOREIGN KEY (home_team) REFERENCES public.team(team_id);


--
-- TOC entry 3249 (class 2606 OID 66164)
-- Name: tournament fkdwrwixxqqfkkyd2v244t4n057; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tournament
    ADD CONSTRAINT fkdwrwixxqqfkkyd2v244t4n057 FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- TOC entry 3245 (class 2606 OID 66144)
-- Name: marketpick fkr5hxx6r4il4csdjistb89l2rg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marketpick
    ADD CONSTRAINT fkr5hxx6r4il4csdjistb89l2rg FOREIGN KEY (market_id) REFERENCES public.market(market_id);


-- Completed on 2022-04-04 15:36:42

--
-- PostgreSQL database dump complete
--