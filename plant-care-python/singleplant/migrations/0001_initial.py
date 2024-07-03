# Generated by Django 5.0.6 on 2024-07-02 22:45

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="SinglePlant",
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
                ("scientific_name", models.CharField(max_length=200)),
                ("plant_description", models.CharField(max_length=500)),
                ("price", models.DecimalField(decimal_places=2, max_digits=10)),
                ("image_name", models.CharField(blank=True, max_length=256, null=True)),
                ("water", models.CharField(max_length=500)),
                ("light", models.CharField(max_length=999)),
                ("humidity", models.CharField(max_length=999)),
                ("temp", models.CharField(max_length=999)),
                ("toxic", models.CharField(max_length=999)),
                ("fun_fact", models.CharField(max_length=999)),
                ("soil_id", models.IntegerField(null=True)),
            ],
            options={
                "db_table": "plants_single_plant",
            },
        ),
    ]