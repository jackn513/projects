from django.shortcuts import render
from .models import Plant  # Make sure to import your model


def plants_index(request):
    plants = Plant.objects.all()
    return render(request, 'plants_index.html', {'plants': plants})
