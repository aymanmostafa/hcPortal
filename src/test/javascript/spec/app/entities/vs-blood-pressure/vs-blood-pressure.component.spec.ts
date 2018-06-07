/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { VsBloodPressureComponent } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.component';
import { VsBloodPressureService } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.service';
import { VsBloodPressure } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.model';

describe('Component Tests', () => {

    describe('VsBloodPressure Management Component', () => {
        let comp: VsBloodPressureComponent;
        let fixture: ComponentFixture<VsBloodPressureComponent>;
        let service: VsBloodPressureService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBloodPressureComponent],
                providers: [
                    VsBloodPressureService
                ]
            })
            .overrideTemplate(VsBloodPressureComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBloodPressureComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBloodPressureService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VsBloodPressure('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vsBloodPressures[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
