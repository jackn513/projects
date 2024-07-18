# Generated by Django 4.2.13 on 2024-07-10 20:37

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="SingleSoil",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("type", models.CharField(max_length=100)),
                ("ph_level", models.FloatField()),
                ("nutrients", models.TextField()),
                ("description", models.TextField()),
            ],
        ),
        migrations.CreateModel(
            name="Plant",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("name", models.CharField(max_length=100)),
                (
                    "soil",
                    models.ForeignKey(
                        on_delete=django.db.models.deletion.CASCADE,
                        related_name="plants",
                        to="singlesoil.singlesoil",
                    ),
                ),
            ],
        ),
    ]
