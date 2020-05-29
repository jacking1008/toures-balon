﻿// <auto-generated />
using System;
using Javeriana.Convenios.Api.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

namespace Javeriana.Convenios.Api.Migrations
{
    [DbContext(typeof(RepositoryContext))]
    [Migration("20200527160223_InitialCreate")]
    partial class InitialCreate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn)
                .HasAnnotation("ProductVersion", "3.1.4")
                .HasAnnotation("Relational:MaxIdentifierLength", 63);

            modelBuilder.Entity("Javeriana.Convenios.Api.Models.Ciudad", b =>
                {
                    b.Property<int>("Codigo")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer")
                        .HasAnnotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn);

                    b.Property<string>("Nombre")
                        .HasColumnType("text");

                    b.Property<int?>("PaisCodigo")
                        .HasColumnType("integer");

                    b.HasKey("Codigo");

                    b.HasIndex("PaisCodigo");

                    b.ToTable("Ciudad");
                });

            modelBuilder.Entity("Javeriana.Convenios.Api.Models.Convenio", b =>
                {
                    b.Property<string>("Identificacion")
                        .HasColumnType("text");

                    b.Property<string>("Correo")
                        .HasColumnType("text");

                    b.Property<int?>("FK_Convenio_Ciudad_CiudadCodigo")
                        .HasColumnType("integer");

                    b.Property<int?>("FK_Convenio_Pais_PaisCodigo")
                        .HasColumnType("integer");

                    b.Property<DateTime?>("FechaVigencia")
                        .HasColumnType("timestamp without time zone");

                    b.Property<string>("NombreProveedor")
                        .HasColumnType("text");

                    b.Property<int?>("TipoConvenio")
                        .HasColumnType("integer");

                    b.HasKey("Identificacion");

                    b.HasIndex("FK_Convenio_Ciudad_CiudadCodigo");

                    b.HasIndex("FK_Convenio_Pais_PaisCodigo");

                    b.ToTable("Convenio");
                });

            modelBuilder.Entity("Javeriana.Convenios.Api.Models.Pais", b =>
                {
                    b.Property<int>("Codigo")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("integer")
                        .HasAnnotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn);

                    b.Property<string>("Nombre")
                        .HasColumnType("text");

                    b.HasKey("Codigo");

                    b.ToTable("Pais");
                });

            modelBuilder.Entity("Javeriana.Convenios.Api.Models.Ciudad", b =>
                {
                    b.HasOne("Javeriana.Convenios.Api.Models.Pais", "Pais")
                        .WithMany()
                        .HasForeignKey("PaisCodigo");
                });

            modelBuilder.Entity("Javeriana.Convenios.Api.Models.Convenio", b =>
                {
                    b.HasOne("Javeriana.Convenios.Api.Models.Ciudad", "Ciudad")
                        .WithMany()
                        .HasForeignKey("FK_Convenio_Ciudad_CiudadCodigo");

                    b.HasOne("Javeriana.Convenios.Api.Models.Pais", "Pais")
                        .WithMany()
                        .HasForeignKey("FK_Convenio_Pais_PaisCodigo");
                });
#pragma warning restore 612, 618
        }
    }
}
